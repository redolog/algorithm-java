package com.algorithm.dataStructure.linkedList.monotonous;

import com.algorithm.dataStructure.linkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/remove-nodes-from-linked-list/
 *
 * @author songhuilong  @date 2025/11/16
 */
public class RemoveNodesInLinkedList {

    static class MonotonousStackSolution {
        public ListNode removeNodes(ListNode head) {
            // 算法概述：
            // 题目所求最终要形成一个递减的序列，借助一个额外的队列，逐步遍历链表，当前节点值比前序节点值更大时，将前序的节点丢弃
            // 最终队列中仅剩下降趋势的序列，重组为一个新的链表
            ListNode dummy = new ListNode(-1, head);

            // 初始化一个额外的队列
            Deque<ListNode> deque = new ArrayDeque<>();
            ListNode curr = head;
            while (curr != null) {
                // 将队列中前序值更小的节点出队
                while (!deque.isEmpty() && deque.peekLast().val < curr.val) {
                    deque.pollLast();
                }
                deque.offerLast(curr);
                curr = curr.next;
            }

            curr = dummy;
            // 以入队顺序构建新链表
            while (!deque.isEmpty()) {
                curr.next = deque.pollFirst();
                curr = curr.next;
            }
            return dummy.next;
        }
    }

    static class ReverseAndCheckSolution {
        public ListNode removeNodes(ListNode head) {
            // 算法概述：
            // 题目所求最终要形成一个递减的序列，逐个节点判断当前 前序是否有更小的值，需要借助额外的空间暂存前序值
            // 我们可以预处理，将既定链表反转，反转后的链表所求变为了一个递增的序列
            // 逐个节点判断，后续节点更小时，直接跳过下一节点，重复这个过程
            // 反证：
            // 1. 题目给定的链表，为何不能逐个判断？以 5,4,2,13 为例，到达13时，才能感知到其左侧更小值需要删除；
            // 2. 反转后，链表变为 13,2,4,5 ，从13出发，可以立刻感知2,4,5为右侧更小元素，并且可以在链表上原地删除；
            head = reverse(head);
            ListNode dummy = new ListNode(-1, head);

            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                if (curr.next == null || curr.next.val >= curr.val) {
                    prev = curr;
                    curr = curr.next;
                } else if (curr.next.val < curr.val) {
                    // 删除curr.next节点
                    curr.next = curr.next.next;
                }
            }

            return reverse(dummy.next);
        }

        private ListNode reverse(ListNode curr) {
            ListNode prev = null;
            while (curr != null) {
                ListNode nextTmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTmp;
            }
            return prev;
        }
    }
}
