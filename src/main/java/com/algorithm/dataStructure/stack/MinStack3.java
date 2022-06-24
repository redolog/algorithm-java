package com.algorithm.dataStructure.stack;

import java.util.Stack;

public class MinStack3 {

    Stack<int[]> stack;

    // 使用一个栈存储，内部存数据，0位存原数字，1位存对应最小值
    public MinStack3() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int[] prev = stack.peek();
            int smaller = val < prev[1] ? val : prev[1];
            stack.push(new int[]{val, smaller});
        }
    }

    public int pop() {
        // 数组同步跟随stack出栈
        return stack.pop()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public int top() {
        return stack.peek()[0];
    }

    public void clear() {
        stack.clear();
    }

}
