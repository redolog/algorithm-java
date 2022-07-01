package com.algorithm.hash.consistentHash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于传统hash表实现的集群协调者
 * <p>
 * 存储 数据key->节点
 *
 * @author dragonsong  @date 2022/7/1
 */
public class HashTableCoordinator {

    /**
     * 集群节点
     */
    private final List<Node> nodeList;
    /**
     * 数据key->节点
     */
    private final Map<String, Node> key2Node;
    /**
     * 数据插入下标
     */
    private int index;

    /**
     * 初始化协调者信息
     *
     * @param nodeList 节点列表
     */
    public HashTableCoordinator(List<Node> nodeList) {
        this.nodeList = nodeList;
        this.key2Node = new HashMap<>();
    }

    /**
     * 存入kv数据，根据key顺序插入到下一个节点
     *
     * @param key  K
     * @param data V
     */
    public void put(String key, Object data) {
        Node node = nodeList.get(index);
        // 关联数据key->节点
        key2Node.put(key, node);
        // 节点存储真实 k-v
        node.put(key, data);
        System.out.println("往node：" + node + " 中存数据，key：：" + key + " value：：" + data);
        // 存储下标前移
        index = (index + 1) % nodeList.size();
    }

    public Object getValueByKey(String key) {
        Node node = key2Node.get(key);
        if (node == null) {
            throw new IllegalStateException("节点获取失败，数据key:" + key);
        }
        Object data = node.get(key);
        System.out.println("从node：" + node + " 中查数据，key：：" + key + " value：：" + data);
        return data;
    }

    /**
     * 集群新增节点
     *
     * @param newNode 新节点实例
     */
    public void addNode(Node newNode) {
        nodeList.add(newNode);
        // 此时数据分布不均，如果不rebalance，newNode上数据会一直少于其他节点
        // 所以需要搬移数据进而使得数据分布均匀
        // 由于我们只知道通过数据key获取节点，而根据节点难获取数据，所以搬移数据只能全部遍历，平衡化
        System.err.println("这是一个 O(n) n表示数据量 级别的开销");
    }

    /**
     * 集群下线节点
     *
     * @param oldNode 已有节点实例
     */
    public void removeNode(Node oldNode) {
        nodeList.remove(oldNode);
        // 复杂度同 addNode
        System.err.println("这是一个 O(n) n表示数据量 级别的开销");
    }

}
