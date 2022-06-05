package com.algorithm.dataStructure.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random 为 null 或指向链表中的节点。
 * <p>
 * https://leetcode.cn/problems/copy-list-with-random-pointer/
 *
 * @author dragonsong  @date 2022/6/4
 */
public class CopyListWithRandomPointer {

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     * <p>
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.2 MB
     * , 在所有 Java 提交中击败了
     * 15.37%
     * 的用户
     * 通过测试用例：
     * 19 / 19
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy;
        RandomListNode curr = head;

        List<RandomListNode> nodeList = new ArrayList<>();

        while (curr != null) {
            RandomListNode node = new RandomListNode(curr.val);
            nodeList.add(node);

            pre = pre.next = node;
            curr = curr.next;
        }
        pre.next = null;

        curr = head;
        RandomListNode newCurr = dummy.next;
        while (curr != null) {
            RandomListNode random = curr.random;
            // 计算random位置
            if (random == null) {
                newCurr.random = null;
            } else {
                int randomLeftStep = 0;
                while (random != null) {
                    ++randomLeftStep;
                    random = random.next;
                }
                newCurr.random = nodeList.get(nodeList.size() - randomLeftStep);
            }

            newCurr = newCurr.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    public RandomListNode copyRandomListWithMap(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy;
        RandomListNode curr = head;

        Map<RandomListNode, RandomListNode> old2New = new HashMap<>();

        while (curr != null) {
            RandomListNode node = new RandomListNode(curr.val);
            old2New.put(curr, node);

            pre = pre.next = node;
            curr = curr.next;
        }
        pre.next = null;

        curr = head;
        while (curr != null) {
            old2New.get(curr).random = old2New.get(curr.random);

            curr = curr.next;
        }
        return dummy.next;
    }

    public RandomListNode copyRandomListWithShadow(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // 先遍历，创建链表影子节点，设置next
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode nextTmp = curr.next;
            RandomListNode currNew = new RandomListNode(curr.val);
            curr.next = currNew;
            currNew.next = nextTmp;
            curr = nextTmp;
        }
        // 当前节点.next此时为新创建的影子节点，而.random.next即为新创建的random新节点，因此可以再遍历一次，设置影子节点的random
        // 设置random、分离新旧链表指针需分开
        curr = head;
        while (curr != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;

            curr = curr.next.next;
        }
        RandomListNode dummy = new RandomListNode(-1);
        curr = head;
        while (curr != null) {
            RandomListNode shadow = curr.next;
            if (dummy.next == null) {
                dummy.next = shadow;
            }
            RandomListNode originalNext = shadow.next;
            // 影子节点next为null
            if (originalNext != null) {
                shadow.next = originalNext.next;
            }
            curr.next = originalNext;
            curr = curr.next;
        }

        return dummy.next;
    }
}
