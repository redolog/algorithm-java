package com.algorithm.dataStructure.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 复习复制复杂链表
 *
 * @author dragonsong  @date 2022/6/24
 */
public class CopyComplicatedRandomList {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41 MB
     * , 在所有 Java 提交中击败了
     * 47.15%
     * 的用户
     * 通过测试用例：
     * 18 / 18
     */
    public Node copyRandomListWithShadowNode(Node head) {
        // 思路：先将新建节点插入到 node与node.next中间
        // 再根据新建的链条关联random指针
        // 再剥离新建的节点
        Node curr = head;
        while (curr != null) {
            // 插入新节点
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;

            // 挪动
            curr = newNode.next;
        }

        curr = head;
        while (curr != null) {
            Node newNode = curr.next;
            Node randomNewNode = curr.random == null ? null : curr.random.next;
            newNode.random = randomNewNode;

            curr = newNode.next;
        }

        // 剥离两条链
        Node dummy = new Node(-1);
        curr = head;
        while (curr != null) {
            Node newNode = curr.next;
            if (dummy.next == null) {
                dummy.next = newNode;
            }

            curr.next = newNode.next;
            newNode.next = curr.next == null ? null : curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> old2New = new HashMap<>();

        Node dummy = new Node(-1);
        Node newPrev = dummy;

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            if (dummy.next == null) {
                dummy.next = newNode;
            }
            newPrev.next = newNode;
            newPrev = newPrev.next;

            old2New.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            old2New.get(curr).random = old2New.get(curr.random);
            curr = curr.next;
        }

        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }

        public static Node build(Integer[][] vals) {
            Node dummy = new Node(-1);
            Node current = null;

            Node[] nodeArr = new Node[vals.length];

            for (int i = 0; i < vals.length; i++) {
                Integer[] valPair = vals[i];
                Integer val = valPair[0];
                Node newNode = new Node(val);
                nodeArr[i] = newNode;
                if (current == null) {
                    dummy.next = current = newNode;
                } else {
                    current = current.next = newNode;
                }
            }

            for (int i = 0; i < vals.length; i++) {
                Integer[] valPair = vals[i];
                Integer random = valPair[1];
                nodeArr[i].random = random == null ? null : nodeArr[random];
            }

            return dummy.next;
        }
    }
}
