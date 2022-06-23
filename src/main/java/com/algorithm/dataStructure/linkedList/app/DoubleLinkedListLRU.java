package com.algorithm.dataStructure.linkedList.app;

import com.algorithm.util.MapUtils;
import com.algorithm.util.NumberUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于双端链表的LRU
 * 1. 基于单向链表的lru中，可以发现查找、搬移更新数据、删除数据，复杂度无法降低
 * 2. 基于数组的lru中，查找这一步可以充分利用数组随机访问的优势，增加一个map来快速寻址，但是搬移数据依然无法快速处理
 * <p>
 * 而单向链表中单纯插入、删除的复杂度其实都是 O(1)，O(n)复杂度主要是定位位置带来的
 * <p>
 * map结构天生适合kv寻址，获取到单链表节点后，删除操作还需要获取前序节点，增加一个双向链表即可完美优化这类问题
 * <p>
 * 此类实现不如 LRUCache 精简
 *
 * @author dragonsong  @date 2022/6/23
 */
public class DoubleLinkedListLRU<K, V> {

    /**
     * first head 指向第一个真实节点的prev
     */
    DoubleLinkedListNode<K, V> head;
    /**
     * last tail 指向最后真实节点的next
     */
    DoubleLinkedListNode<K, V> tail;
    /**
     * 当前数据量
     */
    int size;
    /**
     * lru容量
     */
    int capacity;
    /**
     * 通过key定位链表中的双向链表节点
     */
    Map<K, DoubleLinkedListNode<K, V>> k2Node;

    public DoubleLinkedListLRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        k2Node = new HashMap<>(MapUtils.capacity(capacity));
        this.head = new DoubleLinkedListNode<>();
        this.tail = new DoubleLinkedListNode<>();
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        // O(1)
        DoubleLinkedListNode<K, V> node = k2Node.get(key);
        if (node == null) {
            return null;
        }
        // O(1)
        // 删除原位置元素
        removeNode(node);
        insertNewHead(node);
        return node.entry.val;
    }

    public void put(K key, V val) {
        // O(1)
        DoubleLinkedListNode<K, V> targetNode = k2Node.get(key);
        if (targetNode == null) {
            // 数据原来不存在
            if (size == capacity) {
                // 淘汰末尾元素
                evictTail();
            }
            DoubleLinkedListNode<K, V> newNode = new DoubleLinkedListNode<>(key, val);
            insertNewHead(newNode);
            ++size;
        } else {
            // 数据原来已存在，直接更换节点位置
            removeNode(targetNode);
            insertNewHead(targetNode);
        }
    }

    // O(1)
    private void evictTail() {
        DoubleLinkedListNode<K, V> last = tail.prev;
        tail.prev = last.prev;

        last.prev.next = tail;

        last.next = null;
        last.prev = null;
        k2Node.remove(last.entry.key);
        --size;
    }

    // O(1)
    private void insertNewHead(DoubleLinkedListNode<K, V> targetNode) {
        if (head.next == tail) {
            tail.prev = targetNode;
        }
        targetNode.next = head.next;
        targetNode.prev = head;

        head.next.prev = targetNode;

        head.next = targetNode;
        k2Node.put(targetNode.entry.key, targetNode);
    }

    // O(1)
    private void removeNode(DoubleLinkedListNode<K, V> targetNode) {
        targetNode.prev.next = targetNode.next;
        targetNode.next.prev = targetNode.prev;
        k2Node.remove(targetNode.entry.key);
    }

    public DoubleLinkedListNode<K, V> randomNode() {
        int i = NumberUtils.randomInt(size);
        System.out.println("randomI:" + i);
        DoubleLinkedListNode<K, V> curr = head;
        while (i > 0) {
            curr = curr.next;
            --i;
        }
        return curr;
    }

    public void print() {
        System.out.println(this);

        DoubleLinkedListNode<K, V> curr = head;
        while (curr != null) {
            if (curr.entry != null) {
                System.out.print(curr.entry.val + "-->");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "DoubleLinkedListLRU{" + ", size=" + size + ", capacity=" + capacity + '}';
    }

    static class DoubleLinkedListNode<K, V> {
        DoubleLinkedListNode<K, V> prev;
        DoubleLinkedListNode<K, V> next;
        Entry<K, V> entry;

        public DoubleLinkedListNode(K key, V val) {
            this.entry = new Entry<>(key, val);
        }

        public DoubleLinkedListNode() {
        }

        @Override
        public String toString() {
            return "DoubleLinkedListNode{" + "prev=" + (prev == null ? "null" : prev.entry) + ", next=" + (next == null ? "null" : next.entry) + ", entry=" + entry + '}';
        }
    }

    static class Entry<K, V> {
        K key;
        V val;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Entry{" + "key=" + key + ", val=" + val + '}';
        }
    }
}
