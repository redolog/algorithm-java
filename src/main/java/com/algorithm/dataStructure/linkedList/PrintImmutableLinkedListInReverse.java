package com.algorithm.dataStructure.linkedList;


import java.util.ArrayDeque;
import java.util.Deque;

interface ImmutableListNode {

    void printValue();

    ImmutableListNode getNext();
}

/**
 * 1265. 逆序打印不可变链表
 * 给您一个不可变的链表，使用下列接口逆序打印每个节点的值：
 * <p>
 * ImmutableListNode: 描述不可变链表的接口，链表的头节点已给出。
 * 您需要使用以下函数来访问此链表（您 不能 直接访问 ImmutableListNode）：
 * <p>
 * ImmutableListNode.printValue()：打印当前节点的值。
 * ImmutableListNode.getNext()：返回下一个节点。
 * 输入只用来内部初始化链表。您不可以通过修改链表解决问题。也就是说，您只能通过上述 API 来操作链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[4,3,2,1]
 * 示例 2：
 * <p>
 * 输入：head = [0,-4,-1,3,-5]
 * 输出：[-5,3,-1,-4,0]
 * 示例 3：
 * <p>
 * 输入：head = [-2,0,6,4,4,-6]
 * 输出：[-6,4,4,6,0,-2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度在 [1, 1000] 之间。
 * 每个节点的值在 [-1000, 1000] 之间。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 您是否可以：
 * <p>
 * 使用常数级空间复杂度解决问题？
 * 使用线性级时间复杂度和低于线性级空间复杂度解决问题？
 * <p>
 * https://leetcode.cn/problems/print-immutable-linked-list-in-reverse/
 *
 * @author dragonsong  @date 2022/7/11
 */
public class PrintImmutableLinkedListInReverse {

    static class DC {
        /**
         * 分治：每次将入参数据集平分，直到区间只剩一个或者两个节点时打印
         * 时间： 复杂度取决于：递归执行树高，为对数级，O(logn)，每一轮拆分时需要求链表长度，一轮n个时间遍历，整体时间复杂度 O(n*logn)
         * 空间： 递归执行树高，为对数级，O(logn)
         */

        public void printLinkedListInReverse(ListNode head) {
            dc(head, null);
        }

        // [left,right) 为有效节点区间
        private void dc(ListNode left, ListNode right) {
            if (left.getNext() == right) {
                left.printValue();
                return;
            }

            ListNode mid = findMid(left, right);

            // 逆序递归，先处理后半部分
            dc(mid, right);
            dc(left, mid);
        }

        private ListNode findMid(ListNode left, ListNode right) {
            if (left == null) {
                return null;
            }

            ListNode fast = left;
            ListNode slow = left;
            while (fast != null && fast.getNext() != null && fast.getNext() != right && fast != right) {
                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }
            return slow;
        }
    }

    static class ConstantSpaceComplexityWithLen {
        /**
         * 遍历获取链表长度，每次打印链尾
         * 时间： O(n^2)
         * 空间： O(1)
         */
        public void printLinkedListInReverse(ListNode head) {
            int n = listCnt(head);
            ListNode curr = head;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    curr = curr.getNext();
                }
                curr.printValue();
                curr = head;
            }
        }

        private int listCnt(ListNode head) {
            int len = 0;
            while (head != null) {
                ++len;
                head = head.getNext();
            }
            return len;
        }

    }

    class Recursion {

        /**
         * 时间：O(n)
         * 空间：递归执行栈：O(n)
         */

        public void printLinkedListInReverse(ImmutableListNode head) {
            if (head == null) {
                return;
            }
            printLinkedListInReverse(head.getNext());
            head.printValue();
        }
    }

    class Stack {

        /**
         * 时间：O(n)
         * 空间：栈：O(n)
         */

        public void printLinkedListInReverse(ImmutableListNode head) {
            Deque<ImmutableListNode> stack = new ArrayDeque<>();
            while (head != null) {
                stack.offerLast(head);
                head = head.getNext();
            }

            while (!stack.isEmpty()) {
                stack.pollLast().printValue();
            }
        }
    }

}

/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 * public void printValue(); // print the value of this node.
 * public ImmutableListNode getNext(); // return the next node.
 * };
 */
