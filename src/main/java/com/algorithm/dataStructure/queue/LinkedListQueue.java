package com.algorithm.dataStructure.queue;

import com.algorithm.dataStructure.linkedList.ListNode;

/**
 * 基于链表结构的队列
 * O -> O -> O -> O -> O -> null
 * head                tail
 * <p>
 *
 * @author dragonsong  @date 2022/5/20
 */
public class LinkedListQueue {

    /**
     * 队头：出队节点
     */
    ListNode head;
    /**
     * 队尾：入队节点
     */
    ListNode tail;
    /**
     * 队列容量
     */
    int capacity;
    /**
     * 元素数
     */
    int elementCnt;

    public LinkedListQueue(int capacity) {
        tail = new ListNode();
        this.capacity = capacity;
        elementCnt = 0;
    }

    /**
     * 队尾入队
     * 入队：tail.next=newNode ; tail=tail.next
     *
     * @param element 元素
     * @return 成功返回true，队满返回false
     */
    public boolean enqueue(int element) {
        if (elementCnt == capacity) {
            System.err.println("LinkedListQueue 队满");
            return false;
        }

        ListNode newNode = new ListNode(element);
        tail.next = newNode;
        tail = tail.next;
        ++elementCnt;

        if (head == null) {
            head = newNode;
        }

        return true;
    }

    /**
     * 队头出队
     * 出队：return head ; head=head.next
     *
     * @return 队头元素，空时抛异常
     */
    public int dequeue() throws IllegalStateException {
        if (elementCnt == 0) {
            throw new IllegalStateException("SimpleArrayQueue队空");
        }
        ListNode current = this.head;
        head = head.next;
        --elementCnt;
        return current.val;
    }

}
