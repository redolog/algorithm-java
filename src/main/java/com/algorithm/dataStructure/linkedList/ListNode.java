package com.algorithm.dataStructure.linkedList;

import com.algorithm.util.StringUtils;

import java.util.Objects;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ListNode)) {
            return false;
        }

        ListNode listNode = (ListNode) o;

        if (val != listNode.val) {
            return false;
        }
        return next != null ? StringUtils.equals(String.valueOf(next), String.valueOf(listNode.next)) : listNode.next == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next == null ? null : next.val);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + (next == null ? "null" : next.val) +
                '}';
    }

    public static ListNode build(int... vals) {
        ListNode dummy = new ListNode();
        ListNode current = null;
        for (int val : vals) {
            if (current == null) {
                dummy.next = current = new ListNode(val);
            } else {
                current = current.next = new ListNode(val);
            }
        }
        return dummy.next;
    }

    /**
     * @param cycleIdx 环下标
     * @param vals     元素数组
     */
    public static ListNode buildWithCycle(int cycleIdx, int... vals) {
//
//        if (vals.length < 2) {
//            throw new IllegalStateException("环形链表，节点数起码2个起！");
//        }
        ListNode dummy = new ListNode();
        ListNode current = null;
        ListNode cycleNode = null;

        for (int i = 0; i < vals.length; i++) {
            ListNode newNode = new ListNode(vals[i]);
            if (cycleIdx == i) {
                cycleNode = newNode;
            }
            if (current == null) {
                dummy.next = current = newNode;
            } else {
                current = current.next = newNode;
            }
            if (vals.length > 1 && i == vals.length - 1) {
                current.next = cycleNode;
            }
        }

        return dummy.next;
    }

    public ListNode getNext() {
        return next;
    }

    public void printValue() {
        System.out.println(val);
    }

}
