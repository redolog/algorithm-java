package com.algorithm.dataStructure.stack;

/**
 * 基于数组的栈
 *
 * @author dragonsong  @date 2022/5/19
 */
public class ArrayStack {

    /**
     * 元素数组
     */
    Object[] elements;
    /**
     * 数组元素下标
     */
    int idx;
    /**
     * 栈容量
     */
    int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        idx = -1;
        elements = new Object[capacity];
    }

    /**
     * @param element 入栈元素
     * @return 成功返回true，栈满返回false
     */
    public boolean push(Object element) {
        if (idx - 1 == capacity) {
            // 栈满
            return false;
        }
        ++idx;
        elements[idx] = element;
        return true;
    }

    /**
     * 弹出栈顶元素
     *
     * @return 栈顶元素
     * @throws IllegalStateException 栈空时抛异常
     */
    public Object pop() throws IllegalStateException {
        if (idx == -1) {
            throw new IllegalStateException("栈空，无元素可获取");
        }
        Object element = elements[idx];
        --idx;
        return element;
    }

}
