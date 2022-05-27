package com.algorithm.dataStructure.queue.deque;

import com.algorithm.dataStructure.linkedList.DoubleListNode;

/**
 * 基于双向链表实现双端队列
 * <p>
 * 单队列只支持：尾部进，头部出
 * 双向队列的头部、尾部同时支持数据入队、出队
 *
 * @author dragonsong  @date 2022/5/26
 */
public class DoubleListDeque {

    /**
     * 头双向链表节点
     * 同时支持写入、读取
     */
    DoubleListNode head;
    /**
     * 尾部双向链表节点
     * 同时支持写入、读取
     */
    DoubleListNode tail;
    /**
     * 数据量
     */
    int size;

    // capacity暂不考虑

    public DoubleListDeque() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 头部入队
     */
    public void enqueueHead(int val) {
        DoubleListNode newNode = new DoubleListNode(val);
        if (size == 0) {
            head = this.tail = newNode;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        ++size;
    }

    /**
     * 头部出队
     *
     * @return 元素值，空时返回-1
     */
    public int dequeueHead() {
        if (size == 0) {
            return -1;
        }
        int val = this.head.val;
        if (size == 1) {
            head = tail = null;
        }else{
            head.next.prev = null;
            head = head.next;
        }
        --size;
        return val;
    }

    public int peekHead() {
        if (size == 0) {
            return -1;
        }
        return head.val;
    }

    public int peekTail() {
        if (size == 0) {
            return -1;
        }
        return tail.val;
    }

    /**
     * 尾部入队
     */
    public void enqueueTail(int val) {
        DoubleListNode newNode = new DoubleListNode(val);
        if (size == 0) {
            head = this.tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
        ++size;
    }

    /**
     * 尾部出队
     *
     * @return 元素值，空时返回-1
     */
    public int dequeueTail() {
        if (size == 0) {
            return -1;
        }
        int val = this.tail.val;
        if (size==1) {
            head=tail=null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        --size;
        return val;
    }


}
