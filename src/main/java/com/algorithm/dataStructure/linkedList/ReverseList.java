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

    // https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/solution/kan-bu-dong-di-gui-de-kan-guo-lai-xi-wan-1akq/
    public static ListNode reverseListRecurse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 原最后一个节点就是我们新链表的头
        ListNode nextOne = reverseListRecurse(head.next);
        // 下个的节点的next指向当前节点
        head.next.next = head;
        // 赋值next会被上面的.next.next回溯时覆盖，只有最原始head回溯后保留 next==null
        head.next = null;
        return nextOne;
    }
}
