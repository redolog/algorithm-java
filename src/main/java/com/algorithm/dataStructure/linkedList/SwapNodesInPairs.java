package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * @author songhuilong  @date 2022/10/10
 */
public class SwapNodesInPairs {

    static class Recursion {
        /**
         * 返回当前链表被两两交换后的head头
         * <p>
         * 时间复杂度：整个过程完整遍历一次链表，O(n)
         * 空间复杂度：递归有栈开销，O(n)
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 暂存head.next.next（用于反转下一段，并且返回给当前段用作segment.next）
            // 暂存head.next（用于返回新链表的头）
            ListNode third = head.next.next, second = head.next;
            head.next.next = head;
            head.next = swapPairs(third);
            return second;
        }
    }

    static class Traversal {
        /**
         * 时间复杂度：迭代遍历整个链表，O(n)
         * 空间复杂度：只有常数个指针开销，O(1)
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 三指针，012分别指向当前前序、当前、后继节点
            ListNode zero = null, first = head, second = head.next, ans = second;
            while (second != null) {
                ListNode third = second.next;
                second.next = first;
                first.next = third;
                if (zero != null) {
                    zero.next = second;
                }
                zero = first;
                if (third == null) {
                    break;
                }
                first = third;
                second = first.next;
            }
            return ans;
        }
    }


}
