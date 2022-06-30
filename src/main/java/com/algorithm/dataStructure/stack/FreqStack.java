package com.algorithm.dataStructure.stack;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最大频率栈。
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。FreqStack 有两个函数：
 * push(int x)，将整数 x 推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * <p>
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 * <p>
 * ◼ 示例： push [5,7,5,7,4,5] pop() -> 返回 5，因为 5 是出现频率最高的。
 * 栈变成 [5,7,5,7,4]。 pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈 顶。
 * <p>
 * 栈变成 [5,7,5,4]。 pop() -> 返回 5 。
 * <p>
 * 栈变成 [5,7,4]。 pop() -> 返回 4 。
 * <p>
 * 栈变成 [5,7]。
 * <p>
 * https://github.com/0voice/interview_internal_reference/blob/master/01.%E9%98%BF%E9%87%8C%E7%AF%87/1.3.1%20%E6%9C%80%E5%A4%A7%E9%A2%91%E7%8E%87%E6%A0%88.md
 *
 * @author dragonsong  @date 2022/7/1
 */
public class FreqStack {

    /**
     * 值 ——》频率
     */
    Map<Integer, Integer> val2Freq;
    /**
     * 频率--》栈结构
     */
    Map<Integer, Deque<Integer>> freq2Stack;
    /**
     * 当前最大频率
     */
    int maxFreq;

    public FreqStack() {
        val2Freq = new HashMap<>();
        freq2Stack = new HashMap<>();
        maxFreq = 0;
    }

    void push(int val) {
        Integer freq = val2Freq.getOrDefault(val, 0);
        freq++;
        val2Freq.put(val, freq);

        Deque<Integer> stack = freq2Stack.computeIfAbsent(freq, k -> new ArrayDeque<>());
        stack.push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    int pop() {
        if (maxFreq == 0) {
            return -1;
        }
        Deque<Integer> stack = freq2Stack.get(maxFreq);
        if (stack.isEmpty()) {
            return -1;
        }
        Integer val = stack.pop();
        val2Freq.put(val, val2Freq.get(val) - 1);

        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}
