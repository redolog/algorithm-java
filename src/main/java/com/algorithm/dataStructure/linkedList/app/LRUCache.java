package com.algorithm.dataStructure.linkedList.app;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 * <p>
 * https://leetcode.cn/problems/lru-cache/
 *
 * @author dragonsong  @date 2022/6/23
 */
public class LRUCache {

    /**
     * 执行用时：
     * 57 ms
     * , 在所有 Java 提交中击败了
     * 15.16%
     * 的用户
     * 内存消耗：
     * 113.9 MB
     * , 在所有 Java 提交中击败了
     * 26.87%
     * 的用户
     * 通过测试用例：
     * 22 / 22
     */

    int size;
    int capacity;
    Node head;
    Node tail;

    Map<Integer, Node> key2Node;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;

        key2Node = new HashMap<>();
    }

    public int get(int key) {
        Node node = key2Node.get(key);
        if (node == null) {
            return -1;
        }
        deleteNode(node);
        insertNode2Head(node);
        return node.val;
    }

    private void insertNode2Head(Node node) {
        if (size == 0) {
            tail.prev = node;
        }
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;

        head.next = node;

        ++size;
        key2Node.put(node.key, node);
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
        key2Node.remove(node.key);
    }

    public void put(int key, int value) {
        Node node = key2Node.get(key);
        if (node == null) {
            // 原来没有的新节点
            if (size == capacity) {
                deleteNode(tail.prev);
            }
            insertNode2Head(new Node(key, value));
        } else {
            // 原来有，先删，后增
            deleteNode(node);
            node.val = value;
            insertNode2Head(node);
        }
    }

    public void print() {
        System.out.println("size:" + size + " capacity:" + capacity);
        Node curr = head.next;
        while (curr != null) {
            System.out.print(curr.val + "-->");
            curr = curr.next;
        }
        System.out.println();
    }

    static class Node {
        int key;
        int val;

        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
