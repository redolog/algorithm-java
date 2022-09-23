package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/design-linked-list/
 *
 * @author songhuilong  @date 2022/9/23
 */
public class DesignLinkedList {

    static class MyLinkedList {

        // head指向第一个元素
        ListNode head;
        // 最后一个元素指向tail
        ListNode tail;
        // 记录元素个数
        int size;

        public MyLinkedList() {
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            size = 0;
        }

        public int get(int index) {
            ListNode node = getNode(index);
            return node == null || node == head ? -1 : node.val;
        }

        public ListNode getNode(int index) {
            if (index < -1 || index > size - 1) {
                return null;
            }
            if (index == -1) {
                return head;
            }

            ListNode curr = head.next;
            while (index > 0) {
                curr = curr.next;
                index--;
            }
            return curr;
        }

        public void addAtHead(int val) {
            addAfterNode(head, val);
        }

        public void addAfterNode(ListNode node, int val) {
            ++size;
            ListNode newNode = new ListNode(val);
            newNode.next = node.next;
            node.next = newNode;
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                // 如果 index 大于链表长度，则不会插入节点
                return;
            }
            if (index < 0) {
                // 如果index小于0，则在头部插入节点。
                addAtHead(val);
                return;
            }

            ListNode prev = getNode(index - 1);
            if (prev == null) {
                return;
            }
            addAfterNode(prev, val);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode prev = getNode(index - 1);
            if (prev == null) {
                return;
            }
            prev.next = prev.next.next;
            --size;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}
