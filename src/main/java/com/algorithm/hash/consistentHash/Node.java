package com.algorithm.hash.consistentHash;

import java.util.*;

/**
 * 节点，负责存储、运算
 * 代指一台服务或者实例
 *
 * @author dragonsong  @date 2022/7/1
 */
public class Node {

    /**
     * 服务ip
     */
    String ip;
    /**
     * 服务端口
     */
    int port;
    /**
     * 数据存储
     */
    Map<String, Object> key2Data;

    public Node(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.key2Data = new HashMap<>();
    }

    public static List<Node> initClusterNodes() {
        return new ArrayList<Node>() {{
            add(new Node("ip1", 8088));
            add(new Node("ip2", 8089));
            add(new Node("ip3", 8068));
            add(new Node("ip4", 8078));
            add(new Node("ip5", 8058));
            add(new Node("ip6", 8038));
        }};
    }

    /**
     * 存放key/val数据
     *
     * @param key  K
     * @param data V
     */
    void put(String key, Object data) {
        key2Data.put(key, data);
    }

    /**
     * 根据数据key获取实际val数据
     */
    Object get(String key) {
        return key2Data.get(key);
    }

    boolean containsKey(String key) {
        return key2Data.containsKey(key);
    }

    void reloadByKey(String key) {
//        System.out.println("从db拉取缓存数据");
        put(key, Integer.parseInt(key.substring(3)));
    }

    @Override
    public String toString() {
        return "Node{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return port == node.port && Objects.equals(ip, node.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }
}
