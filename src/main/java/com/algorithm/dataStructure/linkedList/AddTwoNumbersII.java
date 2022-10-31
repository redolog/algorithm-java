package com.algorithm.dataStructure.linkedList;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/
 *
 * @author songhuilong  @date 2022/10/31
 */
public class AddTwoNumbersII {

    /**
     * 时间复杂度：整体对入参链表遍历三次
     * 1. 算每个链表长度
     * 2. 构建直接加和、不进位的答案链表
     * 3. 通过递归处理进位
     * <p>
     * 时间：O(n)
     * 空间复杂度：递归有栈开销 O(n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Len = getLen(l1), l2Len = getLen(l2);
        ListNode longerNode, shorterNode;
        int lenGap, lenShorter;
        if (l1Len >= l2Len) {
            longerNode = l1;
            shorterNode = l2;
            lenGap = l1Len - l2Len;
            lenShorter = l2Len;
        } else {
            longerNode = l2;
            shorterNode = l1;
            lenGap = l2Len - l1Len;
            lenShorter = l1Len;
        }
        // 不考虑进位，先把各位加和
        ListNode dummy = new ListNode(), prev = dummy;
        while (lenGap > 0) {
            prev.next = new ListNode(longerNode.val);
            prev = prev.next;
            longerNode = longerNode.next;
            lenGap--;
        }
        while (lenShorter > 0) {
            prev.next = new ListNode(longerNode.val + shorterNode.val);
            prev = prev.next;
            longerNode = longerNode.next;
            shorterNode = shorterNode.next;
            lenShorter--;
        }
        // 再把超过9的位，进位到上一个节点，使用递归的方式可以获取到下一次操作后的结果
        int carry = recoverCarry(dummy.next);
        if (carry == 1) {
            ListNode ans = new ListNode(1);
            ans.next = dummy.next;
            return ans;
        }
        return dummy.next;
    }

    private int recoverCarry(ListNode node) {
        if (node == null) {
            return 0;
        }
        node.val += recoverCarry(node.next);
        // 当前节点大于9，把进位怼给前一个节点
        if (node.val > 9) {
            node.val -= 10;
            return 1;
        }
        return 0;
    }

    private int getLen(ListNode node) {
        int len = 0;
        ListNode curr = node;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
