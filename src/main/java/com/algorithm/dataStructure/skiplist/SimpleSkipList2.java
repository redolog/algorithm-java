package com.algorithm.dataStructure.skiplist;

import static com.algorithm.dataStructure.skiplist.SkipListLevelUtils.MAX_LEVEL;

/**
 * 基于上下左右指针结构的跳表
 *
 * @author dragonsong  @date 2022/6/28
 */
public class SimpleSkipList2<K extends Comparable<K>, V> {


    /**
     * 头节点位于跳表最左上，为查询起点
     */
    Node<K, V> head;
    /**
     * k-v 个数
     */
    int size;
    /**
     * 生成数据的最大层数
     */
    int maxLevel;

    public SimpleSkipList2() {
        head = new Node<>(MAX_LEVEL);
        Node<K, V> curr = head;
        // head每层都生成
        while (curr.level != 0) {
            Node<K, V> lower = curr.copyWithLowerLevel();
            curr.down = lower;
            lower.up = curr;
            curr = curr.down;
        }
        size = 0;
        maxLevel = 0;
    }

    V get(K key) {
        Node<K, V> node = getNode(key);
        if (node == null || node.key == null || node.key.compareTo(key) != 0) {
            return null;
        }
        return node.val;
    }

    /**
     * @param key 待查找的key
     * @return 查找链表中等值元素，或者查找链路上的prev前序节点
     */
    Node<K, V> getNode(K key) {
        Node<K, V> curr = head;
        while (curr != null) {
            // 先同层往右走
            Node<K, V> next = curr.next;

            if (next == null) {
                // 只有head的情况
                if (curr.down == null) {
                    return curr;
                }
                curr = curr.down;
            } else {
                // 已经有数据插入的情况
                // 先同层向右找
                while (next != null && next.key.compareTo(key) <= 0) {
                    curr = next;
                    next = next.next;
                }
                // 无down节点时，返回待插入位置的前序节点
                if (curr.key != null && curr.key.compareTo(key) == 0 || curr.down == null) {
                    return curr;
                }

                // 再往下走
                curr = curr.down;
            }

        }
        return null;
    }

    void put(K key, V val) {
        Node<K, V> prev = getNode(key);
        if (prev == null) {
            throw new IllegalStateException();
        }
        if (prev.key != null && prev.key.compareTo(key) == 0) {
            // 存在：直接更新
            prev.val = val;
            return;
        }
        int level = SkipListLevelUtils.genRandomLevel();
        maxLevel = Math.max(level, maxLevel);

        while (prev.level > 0) {
            prev = prev.down;
        }

        Node<K, V> down = null;
        // 从0往上创建
        for (int i = 0; i < level; i++) {
            Node<K, V> newNode = new Node<>(key, val, i);

            insertHorizontal(prev, newNode);
            insertVertical(down, newNode);

            down = newNode;
            // 寻找下一个prev，有上取上，无上往回倒
            while (prev.up == null) {
                prev = prev.prev;
            }
            prev = prev.up;
        }
        ++size;
    }

    /**
     * 纵向插入
     *
     * @param down    下面的节点
     * @param newNode 新节点
     */
    private void insertVertical(Node<K, V> down, Node<K, V> newNode) {
        if (down == null) {
            return;
        }
        newNode.down = down;
        down.up = newNode;
    }

    /**
     * 横向插入
     *
     * @param prev    原前序节点
     * @param newNode 新节点
     */
    private void insertHorizontal(Node<K, V> prev, Node<K, V> newNode) {
        Node<K, V> prevNext = prev.next;
        prev.next = newNode;
        if (prevNext != null) {
            prevNext.prev = newNode;
        }
        newNode.next = prevNext;
        newNode.prev = prev;
    }

    /**
     * 逐层打印跳表结构
     */
    public void print() {
        Node<K, V> start = head;
        while (start.level > maxLevel) {
            start = start.down;
        }

        System.out.println("maxLevel:" + maxLevel);

        Node<K, V> curr;
        while (start != null && start.level >= 0) {
            System.out.println("当前层数：" + start.level);
            curr = start;
            while (curr != null) {
                System.out.print(curr + "-->");
                curr = curr.next;
            }
            System.out.println();
            start = start.down;
        }
    }


    /**
     * 链表节点
     *
     * @param <K> 键类型，可排序
     */
    static class Node<K extends Comparable<K>, V> {
        /**
         * 保存的键类型
         */
        K key;
        /**
         * 保存的值类型
         */
        V val;
        /**
         * 层数
         */
        int level;
        /**
         * 上下前后节点引用
         */
        Node<K, V> prev, next, up, down;

        public Node(int level) {
            this.level = level;
        }

        public Node(K key, V val, int level) {
            this.key = key;
            this.val = val;
            this.level = level;
        }

        public Node<K, V> copyWithLowerLevel() {
            return new Node<>(this.key, this.val, this.level - 1);
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", val=" + val + '}';
        }
    }
}
