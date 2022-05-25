package com.algorithm.dataStructure.linkedList;

/**
 * 反转双向链表
 *
 * @author dragonsong  @date 2022/5/25
 */
public class ReverseDoubleLinkedList {

    public static DoubleListNode reverseDoubleLinkedList(DoubleListNode head) {
        if (head == null) {
            return null;
        }
        DoubleListNode prev = null;
        DoubleListNode current = head;
        DoubleListNode next;

        while (current != null) {
            next = current.next;

            // current暂存
            DoubleListNode currentTmp = current;

            // 调整当前前后指向
            current.next = prev;
            current.prev = next;

            // 后移指针
            current = next;
            prev = currentTmp;
        }
        return prev == null ? current : prev;
    }
}
