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
 * @author DragonSong  @date 2022/6/24
 * @link {https://leetcode-cn.com/problems/min-stack/}
 */
public class MinStack {

    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 93.20%
     * 的用户
     * 内存消耗：
     * 43.4 MB
     * , 在所有 Java 提交中击败了
     * 24.46%
     * 的用户
     * 通过测试用例：
     * 31 / 31
     */

    Deque<Integer> stackFull;
    // 存储局部最小元素
    Deque<Integer> stackMini;

    public MinStack() {
        stackFull = new LinkedList<>();
        stackMini = new LinkedList<>();
    }

    /**
     * stackFull 不管怎样，都要push
     * stackMini空，插入第一个最小元素，当前值小于mini顶，插入
     */
    public void push(int val) {
        stackFull.push(val);
        if (stackMini.isEmpty() || stackMini.peek() >= val) {
            stackMini.push(val);
        }
    }

    public int top() {
        if (stackFull.isEmpty()) {
            return -1;
        }
        return stackFull.peek();
    }

    public int pop() {
        Integer val = stackFull.pop();
        // 如果出栈了当前mini顶最小的元素，mini跟着出栈
        if (!stackMini.isEmpty() && stackMini.peek().equals(val)) {
            stackMini.pop();
        }
        return val == null ? -1 : val;
    }

    public int getMin() {
        if (stackMini.isEmpty()) {
            return -1;
        }
        return stackMini.peek();
    }

    public void clear() {
        stackFull.clear();
        stackMini.clear();
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
