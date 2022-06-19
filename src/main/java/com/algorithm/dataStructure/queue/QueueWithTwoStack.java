package com.algorithm.dataStructure.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author dragonsong  @date 2022/6/19
 */
public class QueueWithTwoStack {

    /**
     * 执行用时：
     * 36 ms
     * , 在所有 Java 提交中击败了
     * 84.50%
     * 的用户
     * 内存消耗：
     * 49 MB
     * , 在所有 Java 提交中击败了
     * 28.46%
     * 的用户
     * 通过测试用例：
     * 55 / 55
     */

    // 负责入队
    Deque<Integer> stackIn = new LinkedList<>();
    // 负责出队
    Deque<Integer> stackOut = new LinkedList<>();

    public QueueWithTwoStack() {

    }

    public void appendTail(int value) {
        stackIn.addLast(value);
    }

    public int deleteHead() {
        if (stackIn.isEmpty() && stackOut.isEmpty()) {
            return -1;
        }
        if (!stackOut.isEmpty()) {
            return stackOut.pollLast();
        }
        while (!stackIn.isEmpty()) {
            stackOut.addLast(stackIn.pollLast());
        }
        return stackOut.pollLast();
    }

}
