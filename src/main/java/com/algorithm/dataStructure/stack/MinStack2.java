package com.algorithm.dataStructure.stack;

import java.util.Stack;

public class MinStack2 {

    /**
     * stackMini将局部最小值以与stackFull等量的方式存储
     */
    Stack<Integer> stackFull;
    Stack<Integer> stackMini;

    public MinStack2() {
        stackFull = new Stack<>();
        stackMini = new Stack<>();
    }

    public int pop() {
        Integer top = stackFull.pop();
        if (top == null) {
            throw new IllegalStateException();
        }
        stackMini.pop();
        return top;
    }

    public void push(int val) {
        stackFull.push(val);
        if (stackMini.isEmpty()) {
            stackMini.push(val);
        } else {
            Integer miniTop = stackMini.peek();
            int mini = val <= miniTop ? val : miniTop;
            stackMini.push(mini);
        }
    }

    public int getMin() {
        return stackMini.peek();
    }

    public int top() {
        return stackFull.peek();
    }

    public void clear() {
        stackFull.clear();
        stackMini.clear();
    }
}
