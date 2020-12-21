package com.algorithm.dataStructure.linkedList;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author DragonSong  @date 2020/12/21
 * @link {https://leetcode-cn.com/problems/add-two-numbers/}
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode cursor = start;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            // 当前节点和+进位
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            cursor.next = new ListNode(sum >= 10 ? sum % 10 : sum);
            // 遍历挪动
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            cursor = cursor.next;
            carry = sum >= 10 ? 1 : 0;
        }
        return start.next;
    }
}
