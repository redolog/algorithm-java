package com.algorithm.dataStructure.linkedList;

/**
 * 反转链表
 * <p>
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author dragonsong  @date 2022/5/19
 */
public class ReverseList {

    /**
     * a -> b -> c -> d -> null
     * <p>
     * d -> c -> b -> a -> null
     * <p>
     * pre 保存上个节点引用
     * current 迭代指针
     */
    public static ListNode reverseList(ListNode head) {

        ListNode pre = null, current = head;

        while (current != null) {
            ListNode next = current.next;

            // 当前指针next指向 上一项临时变量
            current.next = pre;
            // 上一项临时变量更新值为当前指针
            pre = current;
            // 当前指针挪动
            current = next;
        }

        return pre;
    }
}
