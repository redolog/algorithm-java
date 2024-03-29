package com.algorithm.dataStructure.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 * <p>
 * <p>
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * https://leetcode.cn/problems/linked-list-cycle/
 *
 * @author dragonsong  @date 2022/5/19
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 使用两个步数不同的指针遍历，如果两个节点相遇，说明有环，否则则无
        ListNode slow = head, fast = head.next.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    /**
     * https://leetcode.cn/problems/linked-list-cycle-ii/
     * 检测环位置
     * <p>
     * 142. 环形链表 II
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 不允许修改 链表。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：返回索引为 0 的链表节点
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：返回 null
     * 解释：链表中没有环。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围在范围 [0, 104] 内
     * -105 <= Node.val <= 105
     * pos 的值为 -1 或者链表中的一个有效索引
     * <p>
     * <p>
     * 进阶：你是否可以使用 O(1) 空间解决此题？
     */
    public static ListNode detectCycle(ListNode head) {
        // 这道题目如果用双指针来做，需要将快慢指针的路程关系在纸上画出来，再把环入口、相遇点分开的三端路程关系推导
        // 我还是用简单的set来做

        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> nodeCache = new HashSet<>();

        ListNode current = head;

        while (current != null) {
            if (nodeCache.contains(current)) {
                return current;
            }
            nodeCache.add(current);
            current = current.next;
        }
        return null;
    }

    // @formatter:off
    /**
     * 数学版本。经过作为运营的女朋友的指导，我懂了数学推导的解法。
     * 假设我们的链表长这样：
     *                          B <- <- <- <- <-|
     *                          |               |
     *                          |               |
     * O -> x -> x -> x -> x -> A -> x -> x - > x
     *
     * 其中
     * O：链表起点
     * x：普通的中间节点
     * A：链表环入口
     * B：快慢指针相遇节点
     * D：distance 表示路程
     * s：slow 慢指针路程
     * f：fast 快指针路程
     * n：相遇时快指针在环内已运行的圈数
     * a：OA
     * b：环一圈
     *
     * 我们启动两个指针
     * 慢指针：slow一次前行一步  slow=slow.next
     * 快指针：fast一次前行两步步 fast=fast.next.next
     *
     * 假设现在快慢指针在B点相遇，我们可以得出：
     * 1. 快指针路程为慢指针二倍：f=2*s
     * 2. 快指针路程为慢指针路程（a+AB）加上n圈环路程：f=s+n*b
     * 3. 综上1-2，可得 s=n*b，也就是相遇时，慢指针恰好走了 n圈的环 对应路程
     *
     * 分析：
     * 而我们分析下，当从链表起点走到环入口的地方时，路程满足：a+n*b，n==0时则是慢指针刚好第一次经过环入口，之后便是在环内重复绕圈。
     *
     * 此时，根据上方3结论：慢指针恰好走了 n*b，那么只要慢指针再走 a 的路程，就到了A点。
     *
     * 因此，程序可以这么写：快慢指针运行，第一次相遇（B点）后，令快指针回到O点，以一步的步长前进，当两个指针再次相遇时，此时恰好是A点，即题目所求。
     *
     */
    // @formatter:on
    public static ListNode detectCycleWithMath(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                break;
            }
        }
        while (fast != null && slow != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
