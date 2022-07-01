package com.algorithm.hash.consistentHash;

import com.algorithm.util.MurmurHashUtils;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

// @formatter:off
/**
 * 一致性hash
 * <p>
 * 假定我们的hash结构现在存储的是 数据key->访问节点 ，那么通过数据key查询时就可以定位到实际存储的节点，也就起到了数据分区、负载均衡的作用。
 * <p>
 * 首先回顾下传统hash函数，也叫散列函数，目的是将指定的入参转换成一个固定的key，如hashCode、MD5、Murmurhash
 * 而传统hashtable、hashmap的实现下，一旦节点失效，则需要挪动所有的key（因为我们存的是 key->节点，如果），rehash分布，开销巨大。
 * 这里可参考 HashTableCoordinator
 * @see HashTableCoordinator
 *
 * <p>
 * 而一致性hash，将增删节点后的开销降低到了最低。
 * 设计思路：
 * 1. 使用环状结构存储节点；
 * 2. 环上，节点之间增加若干虚拟节点，供映射 虚拟节点->真实节点 的关系；
 *  2.1 增加虚拟节点的原因是为了均衡环上数据的分布，因为数据要找节点，而只有真实节点的话，增删一个节点必然导致节点间距不同、分布不均；
 *  2.2 而这里我们加入了足够多的虚拟节点，每个虚拟节点按顺序关联到真实节点上，虚拟节点在环上分布足够均匀；
 *  2.3 新增节点：创建一个真实节点，同时根据hash均匀创建环上的若干虚拟节点；
 *  2.4 下线节点：去掉node，也去掉关联的一批虚拟节点，数据key下次查找时根据环上hashcode顺次查找到另一个虚拟节点上，触发对应数据的更新，由于虚拟节点足够多，数据更新被延迟加载，同时分布够均匀；
 * 3. 根据key查找节点的过程：
 *  3.1 根据key生成hashcode，在环上根据hashcode顺序查找，找到对应虚拟节点，就找到了真实节点；
 *
 *
 * @author dragonsong  @date 2022/7/1
 */
// @formatter:on
public class ConsistentHashCoordinator {

    /**
     * 虚拟节点hash：真实节点 映射
     * 环的结构使用 SortedMap，实现可选 TreeMap 基于红黑树 或者 ConcurrentSkipListMap 基于跳表
     */
    private final SortedMap<Long, Node> virtualHash2Node;
    /**
     * 一个真实节点对应的虚拟节点数量
     */
    private final int virtualCntPerNode;
    /**
     * 节点读取量
     */
    Map<Node, Integer> node2ReadCnt;

    /**
     * 初始化一致性hash环： 虚拟hash映射到真实节点
     *
     * @param nodeList          节点列表
     * @param virtualCntPerNode 一个真实节点对应多少个虚拟节点
     */
    public ConsistentHashCoordinator(List<Node> nodeList, int virtualCntPerNode) {
        this.virtualHash2Node = new ConcurrentSkipListMap<>();
        this.virtualCntPerNode = virtualCntPerNode;
        for (Node node : nodeList) {
            addNode(node);
        }
        node2ReadCnt = new LinkedHashMap<>();
    }

    /**
     * 存入kv数据，根据key获取到hash值，在环上找到下一个虚拟节点，根据环映射获取真实节点
     *
     * @param key  K
     * @param data V
     */
    public void put(String key, Object data) {
        Node node = getNodeByKey(key);
        // 节点数据存储
        node.put(key, data);
    }

    @NotNull
    private Node getNodeByKey(String key) {
        Long hash = MurmurHashUtils.hash(key);
        SortedMap<Long, Node> tailMap = virtualHash2Node.tailMap(hash);
        // hash值后面如果有值就从后面取，没有就从头取，环状遍历
        Long virtualHash = tailMap.isEmpty() ? virtualHash2Node.firstKey() : tailMap.firstKey();
        Node node = virtualHash2Node.get(virtualHash);
        if (node == null) {
            throw new IllegalStateException("节点获取失败，数据key:" + key);
        }
        return node;
    }

    public Object getValueByKey(String key) {
        Node node = getNodeByKey(key);
        node2ReadCnt.put(node, node2ReadCnt.getOrDefault(node, 0) + 1);
        if (node.containsKey(key)) {
            Object data = node.get(key);
//            System.out.println("从node：" + node + " 中查数据，key：：" + key + " value：：" + data);
            return data;
        }
//        System.out.println("从node：" + node + " 中重载数据，key：：" + key);
        node.reloadByKey(key);
        return node.get(key);
    }

    /**
     * 集群新增节点
     *
     * @param newNode 新节点实例
     */
    public void addNode(Node newNode) {
        for (int i = 0; i < virtualCntPerNode; i++) {
            Long hash = MurmurHashUtils.hash("virtualNodeKey" + newNode.ip + newNode.port + i);
            virtualHash2Node.put(hash, newNode);
        }
    }

    /**
     * 集群下线节点
     * 删除虚拟节点：真实节点映射后，环上依然存在其他节点以及虚拟的映射，根据key依然可以定位某个节点，如果数据不存在，执行reload
     *
     * @param oldNode 已有节点实例
     */
    public void removeNode(Node oldNode) {
        Iterator<Map.Entry<Long, Node>> iterator = virtualHash2Node.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Node> entry = iterator.next();
            Long virtualHash = entry.getKey();
            Node node = virtualHash2Node.get(virtualHash);
            if (node != null && node.equals(oldNode)) {
                iterator.remove();
            }
        }
    }

    public void clearRead() {
        node2ReadCnt.clear();
    }

    public void print() {
        Map<Node, Integer> node2VirtualCnt = new LinkedHashMap<>();
        for (Map.Entry<Long, Node> entry : virtualHash2Node.entrySet()) {
            Node node = entry.getValue();
            node2VirtualCnt.put(node, node2VirtualCnt.getOrDefault(node, 0) + 1);
        }
        System.out.println("==============");
        System.out.println(node2VirtualCnt);
        System.out.println("==============");
        System.out.println("==============");
        System.out.println(node2ReadCnt);
        System.out.println("==============");
    }

}
