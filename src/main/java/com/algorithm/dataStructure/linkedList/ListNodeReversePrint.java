package com.algorithm.dataStructure.linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author dragonsong  @date 2022/6/19
 */
public class ListNodeReversePrint {

    int[] ansArr;
    // 元素数量
    int cnt = 0;
    // 存储下标
    int j = 0;

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.9 MB
     * , 在所有 Java 提交中击败了
     * 56.27%
     * 的用户
     * 通过测试用例：
     * 24 / 24
     */
    public int[] reversePrint(ListNode node) {
        if (node == null) {
            return new int[0];
        }

        recurse(node);
        return ansArr;
    }

    private void recurse(ListNode node) {
        if (node == null) {
            // 最后一个节点，边界返回，同时初始化结果数组
            ansArr = new int[cnt];
            return;
        }
        ++cnt;
        recurse(node.next);
        ansArr[j] = node.val;
        ++j;
    }


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 69.66%
     * 的用户
     * 内存消耗：
     * 42 MB
     * , 在所有 Java 提交中击败了
     * 42.21%
     * 的用户
     * 通过测试用例：
     * 24 / 24
     */
    public int[] reversePrintWithStack(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] ans = new int[size];
        int i = 0;
        while (i < size) {
            ans[i++] = stack.pop();
        }
        return ans;
    }
}
