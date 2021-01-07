package com.algorithm.dataStructure.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * @author DragonSong  @date 2021/1/7
 * @link {https://leetcode-cn.com/problems/min-stack/}
 */
public class MinStack {

    // 每次操作用数组记录当前值，最小值
    Deque<int[]> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(new int[]{x, Math.min(stack.peek() != null ? stack.peek()[1] : x, x)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack == null || stack.isEmpty() ? 0 : stack.peek()[0];
    }

    public int getMin() {
        return stack == null || stack.isEmpty() ? 0 : stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
