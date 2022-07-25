package com.algorithm.dataStructure.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * https://leetcode.cn/problems/palindrome-linked-list/
 *
 * @author dragonsong  @date 2022/7/25
 */
public class PalindromeLinkedList {

    static class TwoPointerSolution {
        /*
         * 执行用时：
         * 5 ms
         * , 在所有 Java 提交中击败了
         * 61.44%
         * 的用户
         * 内存消耗：
         * 51.1 MB
         * , 在所有 Java 提交中击败了
         * 97.24%
         * 的用户
         * 通过测试用例：
         * 86 / 86
         */

        /**
         * 在原链表上操作：
         * - 先反转后半段
         * - 判断前后半段是否回文
         * - 再还原后半段
         */
        public boolean isPalindrome(ListNode head) {
            // 通过快慢指针找到前半段结束的位置
            ListNode firstHalfEnd = endOfFirstHalf(new ListNode(-1, head));
            // 反转后半段，返回后半段新的起点
            ListNode secondHalfEnd = reverse(firstHalfEnd.next);

            boolean ans = true;
            ListNode secondHalfCurr = secondHalfEnd;
            ListNode firstHalfCurr = head;
            while (secondHalfCurr != null) {
                if (secondHalfCurr.val != firstHalfCurr.val) {
                    ans = false;
                    break;
                }
                firstHalfCurr = firstHalfCurr.next;
                secondHalfCurr = secondHalfCurr.next;
            }
            // 反转还原后半段
            firstHalfEnd.next = reverse(secondHalfEnd);

            return ans;
        }

        /**
         * @return 前半段最后一个节点
         */
        private ListNode endOfFirstHalf(ListNode dummy) {
            ListNode slow = dummy, fast = dummy;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode node) {
            ListNode prev = null;
            ListNode curr = node;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    static class StackSolution {
        /*
         * 执行用时：
         * 8 ms
         * , 在所有 Java 提交中击败了
         * 34.89%
         * 的用户
         * 内存消耗：
         * 53.7 MB
         * , 在所有 Java 提交中击败了
         * 72.44%
         * 的用户
         * 通过测试用例：
         * 86 / 86
         */

        /**
         * 用一个栈实现倒序
         */
        public boolean isPalindrome(ListNode head) {
            ListNode curr = head;
            int len = 0;
            Deque<ListNode> stack = new ArrayDeque<>();
            while (curr != null) {
                len++;
                stack.offerLast(curr);
                curr = curr.next;
            }

            curr = head;
            int i = 0;
            while (curr != null) {
                if (curr.val != stack.pollLast().val) {
                    return false;
                }
                i++;
                if (i == len / 2 + 1) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }
    }


}
