package com.algorithm.dataStructure.linkedList;

/**
 * 带随机指针的链表
 *
 * @author dragonsong  @date 2022/6/4
 */
public class RandomListNode {

    /**
     * 一个表示 Node.val 的整数。
     */
    public int val;
    /**
     * 链表next指针
     */
    public RandomListNode next;
    /**
     * 随机指针，可能为null
     */
    public RandomListNode random;

    public RandomListNode() {
    }

    public RandomListNode(int val) {
        this.val = val;
    }

    public RandomListNode(int val, RandomListNode next) {
        this.val = val;
        this.next = next;
    }

    public RandomListNode(int val, RandomListNode next, RandomListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public static RandomListNode build(Integer[][] vals) {
        RandomListNode dummy = new RandomListNode();
        RandomListNode current = null;

        RandomListNode[] nodeArr = new RandomListNode[vals.length];

        for (int i = 0; i < vals.length; i++) {
            Integer[] valPair = vals[i];
            Integer val = valPair[0];
            RandomListNode newNode = new RandomListNode(val);
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

    @Override
    public String toString() {
        return "RandomListNode{" +
                "val=" + val +
                ", next=" + (next == null ? "null" : next.val) +
                ", random=" + (random == null ? "null" : random.val) +
                '}';
    }
}
