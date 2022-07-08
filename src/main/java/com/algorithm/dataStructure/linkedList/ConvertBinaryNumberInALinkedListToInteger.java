package com.algorithm.dataStructure.linkedList;

/**
 * 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * <p>
 * https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * @author dragonsong  @date 2022/7/8
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 28.29%
     * 的用户
     * 通过测试用例：
     * 102 / 102
     */
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        int len = getLen(head);
        while (len > 0) {
            ans += head.val == 1 ? Math.pow(2, len - 1) : 0;
            --len;
            head = head.next;
        }
        return ans;
    }

    private int getLen(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            ++len;
            curr = curr.next;
        }
        return len;
    }

}
