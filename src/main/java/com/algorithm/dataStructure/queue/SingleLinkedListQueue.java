package com.algorithm.dataStructure.queue;

import com.algorithm.dataStructure.linkedList.ListNode;

/**
 * 基于单向链表实现的队列
 * <p>
 * 队列：FIFO
 *
 * @author dragonsong  @date 2022/5/26
 */
public class SingleLinkedListQueue {

    /**
     * 出队节点
     */
    ListNode head;
    /**
     * 入队节点
     */
    ListNode tail;
    /**
     * 元素个数
     */
    int size;
    /**
     * 队列容量
     */
    int capacity;

    public SingleLinkedListQueue(int capacity) {
        this.capacity = capacity;
        size = capacity = 0;
    }

    public boolean enqueue(int val) {
        if (size == capacity) {
            System.err.println("SingleLinkedListQueue 已经满了");
            return false;
        }

        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail = tail.next = newNode;
        }

        ++size;
        return true;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("SingleLinkedListQueue 空，无法出队");
        }
        ListNode current = this.head;
        head = head.next;
        --size;
        return current.val;
    }


}
