package com.algorithm.dataStructure.stack;

import com.algorithm.dataStructure.linkedList.ListNode;

import java.util.NoSuchElementException;

/**
 * 基于单链表实现的栈
 * <p>
 * 栈：LIFO
 *
 * @author dragonsong  @date 2022/5/26
 */
public class SingleLinkedListStack {
    /**
     * 入栈、出栈节点
     */
    ListNode head;
    /**
     * 栈容量
     */
    int capacity;
    /**
     * 数据量
     */
    int size;

    public SingleLinkedListStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public SingleLinkedListStack(int capacity, int val) {
        this.capacity = capacity;
        this.size = 0;
        head = new ListNode(val, null);
    }

    public boolean push(int val) {
        if (size == capacity) {
            System.err.println("SingleLinkedListStack 已满，无法push！");
            return false;
        }
        ListNode current = new ListNode(val);
        if (this.head == null) {
            this.head = current;
        } else {
            current.next = head;
            head = current;
        }
        ++size;
        return true;
    }

    public int pop() {
        if (size == 0) {
            throw new NoSuchElementException("SingleLinkedListStack 已空");
        }
        int currentVal = head.val;
        head = head.next;
        --size;
        return currentVal;
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return head.val;
    }
}
