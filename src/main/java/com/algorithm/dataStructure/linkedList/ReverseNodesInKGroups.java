package com.algorithm.dataStructure.linkedList;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * <p>
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 *
 * @author dragonsong  @date 2022/5/27
 */
public class ReverseNodesInKGroups {
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 26.43%
     * 的用户
     * 通过测试用例：
     * 62 / 62
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 表示当前组遍历的组起点
        ListNode start = head;
        // 表示当前组遍历的组终点
        ListNode end = getGroupEndByStartAndGroupSize(start, k);
        if (end == null) {
            return start;
        }
        // 表示当前组遍历的组next
        ListNode groupNext = end.next;
        // 表示整个链表的引用
        ListNode dummy = new ListNode(-1, end);
        // 表示当前组遍历的prev
        ListNode groupPrev = null;

        while (end != null) {
            // 先反转
            reverseGroupNodes(start, groupPrev, groupNext);

            // 获取下一组的范围
            end = getGroupEndByStartAndGroupSize(groupNext, k);

            // 下一组的前驱 == 上一组的start
            groupPrev = start;
            // 下一组的start == 当前组的next
            start = groupNext;
            // 下一组不够一组了，设置当前组的next
            if (end == null && groupPrev != null) {
                groupPrev.next = groupNext;
            }
            // 下一组够一组，移动组的next到计算之后end的next
            if (end != null) {
                groupNext = end.next;
            }
        }

        return dummy.next;
    }

    /**
     * 反转组内节点
     *
     * @param start     当前组开始节点
     * @param groupPrev 组前驱
     * @param groupNext 组后继
     * @return end 当前组结束节点
     */
    public static ListNode reverseGroupNodes(ListNode start, ListNode groupPrev, ListNode groupNext) {
        // 组内prev
        ListNode prev = groupPrev;
        ListNode curr = start;
        while (curr != groupNext) {
            // 组prev不为null，即当组已经经过了处理后，将上一组的prev.next指向当前遍历指针，一直指到本组最后一个节点
            if (groupPrev != null) {
                groupPrev.next = curr;
            }
            if (curr == null) {
                break;
            }

            // 反转
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        // 本组遍历完毕
        groupNext = prev.next;
        return prev;
    }

    /**
     * 根据组起点+步长，获取组终点节点
     *
     * @param start     组起点
     * @param groupSize 组长度
     * @return 本组长度不够时返回 null
     */
    public static ListNode getGroupEndByStartAndGroupSize(ListNode start, int groupSize) {
        ListNode curr = start;
        int stepCnt = 0;
        while (curr != null && stepCnt < groupSize - 1) {
            curr = curr.next;
            ++stepCnt;
        }
        return curr;
    }
}
