package com.algorithm.dataStructure.linkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/reorder-list/
 *
 * @author songhuilong001  @date 2023/1/29
 */
public class ReorderList {

    static class MiddleReverseMergeSolution {
        public ListNode reorderList(ListNode head) {
            ListNode middle = middleNode(head);

            ListNode reversedMiddleHead = reverseList(middle.next);
            middle.next = null;

            mergeTwoLists(head, reversedMiddleHead);
            return head;
        }

        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head.next;
            while (fast != null) {
                slow = slow.next;
                if (fast.next == null) {
                    break;
                }
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode curr = head, pre = null;
            while (curr != null) {
                ListNode next = curr.next;

                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = l1;
            while (l1 != null && l2 != null) {
                ListNode next1 = l1.next, next2 = l2.next;
                l1.next = l2;
                l2.next = next1;

                l1 = next1;
                l2 = next2;
            }
            return head;
        }
    }

    static class ArraySolution {
        public ListNode reorderList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode curr = head;
            while (curr != null) {
                list.add(curr);
                curr = curr.next;
            }

            // 依次改变头尾节点的指针
            // 左右分别指向原链表头、尾
            int l = 0, r = list.size() - 1;
            while (l < r) {
                list.get(l).next = list.get(r);
                l++;
                if (l == r) {
                    break;
                }
                list.get(r).next = list.get(l);
                r--;
            }
            list.get(l).next = null;
            return head;
        }
    }

    static class StackSolution {
        /**
         * 题目要求改变原链表节点引用，此解法错误！！！
         */
        public ListNode reorderList(ListNode head) {
            Deque<ListNode> stk = new ArrayDeque<>();
            ListNode curr = head;
            while (curr != null) {
                stk.offerLast(curr);
                curr = curr.next;
            }

            ListNode dummy = new ListNode();
            curr = dummy;
            ListNode currOriginal = head;
            int n = stk.size(), i = 0;
            while (i < n) {
                curr.next = new ListNode(currOriginal.val);
                curr = curr.next;
                currOriginal = currOriginal.next;
                i++;

                if (i < n) {
                    curr.next = new ListNode(stk.pollLast().val);
                    curr = curr.next;
                    i++;
                }
            }
            return dummy.next;
        }
    }


}
