package com.algorithm.dataStructure.linkedList.app;

/**
 * 基于链表的lru
 *
 * @author dragonsong  @date 2022/6/23
 */
public class LinkedListLRU<T> {

    /**
     * 最新数据保存在链表头，最老数据逐渐搬移到链表尾
     */
    LRUListNode<T> dummy;
    /**
     * lru容量
     */
    int capacity;
    /**
     * 当前数据量
     */
    int size;

    public LinkedListLRU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.dummy = new LRUListNode<T>();
    }

    /**
     * 每次访问：
     * - 无数据时返回null
     * - 有数据时获取到位置，将node搬移到链表头
     * <p>
     * 每次均需遍历整个链表，访问复杂度 O(n)
     *
     * @param val 待查询的key
     * @return 命中的链表节点
     */
    public LRUListNode<T> get(T val) {
        LRUListNode<T> prev = dummy;
        while (prev.next != null) {
            if (prev.next.val.equals(val)) {
                LRUListNode<T> root = dummy.next;
                // 删除curr当前位置
                LRUListNode<T> curr = prev.next;
                prev.next = curr.next;
                // 挪动curr到链表头
                dummy.next = curr;
                curr.next = root;
                return curr;
            } else {
                prev = prev.next;
            }
        }
        return null;
    }

    /**
     * 每次插入：
     * - 原来无对应数据时，将val插入到root的位置，同时判断是否达到capacity，如果达到，淘汰链表尾部节点
     * - 有数据时，找到原位置并删除，插入到root
     * <p>
     * 插入时也需要先遍历链表，复杂度 O(n)
     * 单插入、删除节点复杂度均为
     *
     * @param val 待插入的val
     */
    public void put(T val) {
        if (dummy.next == null) {
            dummy.next = new LRUListNode<>(val);
            if (size > capacity) {
                deleteTail();
            }
            ++size;
            return;
        }

        LRUListNode<T> prev = findPrevByVal(val);
        if (prev == null) {
            insertByPrev(dummy, val);
            if (size > capacity) {
                deleteTail();
            }
        } else {
            deleteByPrev(prev);
            insertByPrev(dummy, val);
        }
    }

    private void deleteByPrev(LRUListNode<T> prev) {
        prev.next = prev.next.next;
        --size;
    }

    /**
     * 根据前序节点插入
     *
     * @param prev 前序
     * @param val  当前节点值
     */
    private void insertByPrev(LRUListNode<T> prev, T val) {
        LRUListNode<T> nextTmp = prev.next;
        LRUListNode<T> newNode = new LRUListNode<>(val);
        newNode.next = nextTmp;
        prev.next = newNode;
        ++size;
    }

    /**
     * 遍历到尾部，遍历复杂度 O(n)，删除复杂度 O(1)
     */
    private void deleteTail() {
        if (dummy.next == null) {
            return;
        }

        LRUListNode<T> prev = dummy;
        while (prev.next.next != null) {
            prev = prev.next;
        }
        prev.next = null;
        --size;
    }

    private LRUListNode<T> findPrevByVal(T val) {
        LRUListNode<T> prev = dummy;
        while (prev.next != null) {
            if (prev.next.val.equals(val)) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    void print() {
        System.out.println(this);

        LRUListNode<T> curr = dummy.next;
        while (curr != null) {
            System.out.print(curr.val + "-->");
            curr = curr.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "LinkedListLRU{" +
                "capacity=" + capacity +
                ", size=" + size +
                '}';
    }

    static class LRUListNode<T> {

        T val;

        LRUListNode<T> next;

        public LRUListNode() {
        }

        public LRUListNode(T val) {
            this.val = val;
        }
    }
}
