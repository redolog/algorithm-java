package com.algorithm.dataStructure.linkedList;

import com.algorithm.util.StringUtils;

import java.util.Objects;

/**
 * 双向链表节点
 *
 * @author dragonsong  @date 2022/5/25
 */
public class DoubleListNode {

    public int val;

    public DoubleListNode prev;

    public DoubleListNode next;

    public DoubleListNode() {
    }

    public DoubleListNode(int val, DoubleListNode prev) {
        this.val = val;
        this.prev = prev;
    }
    public DoubleListNode(int val) {
        this.val = val;
    }

    public DoubleListNode(int val, DoubleListNode prev, DoubleListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public static DoubleListNode build(int... vals) {
        if (vals == null) {
            return null;
        }
        if (vals.length == 1) {
            return new DoubleListNode(vals[0], null, null);
        }

        DoubleListNode prev = null;
        DoubleListNode current = new DoubleListNode(vals[0], prev);
        DoubleListNode next = new DoubleListNode(vals[1], current);
        current.next = next;

        DoubleListNode dummy = new DoubleListNode(-1, null, current);

        for (int i = 1; i < vals.length - 1; i++) {
            // 上一步的next
            DoubleListNode nextTmp = next;
            // 创建下一次遍历对应next
            next = new DoubleListNode(vals[i + 1], current);
            // 本次next.next为刚创建的下一个next
            nextTmp.next = next;
            // 下一次的next的prev指向当前next
            next.prev = nextTmp;
            // current右移
            current = nextTmp;
        }
        next.next = null;
        return dummy.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DoubleListNode)) {
            return false;
        }
        DoubleListNode that = (DoubleListNode) o;
        return val == that.val &&
                StringUtils.equals(String.valueOf(prev), String.valueOf(that.prev)) &&
                StringUtils.equals(String.valueOf(next), String.valueOf(that.next));
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, prev, next);
    }

    @Override
    public String toString() {
        return "DoubleListNode{" +
                "val=" + val +
                ", prev=" + (null == prev ? "null" : prev.val) +
                ", next=" + (null == next ? "null" : next.val) +
                '}';
    }
}
