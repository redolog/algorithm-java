package com.algorithm.dataStructure.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * @author dragonsong  @date 2022/6/27
 */
public class MaxQueue {

    /*
     * 执行用时：
     * 25 ms
     * , 在所有 Java 提交中击败了
     * 89.73%
     * 的用户
     * 内存消耗：
     * 49.1 MB
     * , 在所有 Java 提交中击败了
     * 55.59%
     * 的用户
     * 通过测试用例：
     * 34 / 34
     */

    /**
     * 存储队列每项数据
     */
    Queue<Integer> queue;
    /**
     * 存储当前queue对应最大值，单调递减队列
     */
    Deque<Integer> maxQ;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQ = new LinkedList<>();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQ.isEmpty() && value > maxQ.peekLast()) {
            // 队尾小元素出队
            maxQ.pollLast();
        }
        maxQ.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        // 当前值是最大值时，淘汰一个maxQ最大值元素
        Integer first = queue.poll();
        if (!maxQ.isEmpty() && maxQ.peekFirst().equals(first)) {
            maxQ.pollFirst();
        }
        return first;
    }

    public int max_value() {
        if (maxQ.isEmpty()) {
            return -1;
        }
        return maxQ.peekFirst();
    }
}
