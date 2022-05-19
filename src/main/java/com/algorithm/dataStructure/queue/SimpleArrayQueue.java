package com.algorithm.dataStructure.queue;

/**
 * 基于数组的队列实现
 * queue: FIFO
 *
 * @author dragonsong  @date 2022/5/19
 */
public class SimpleArrayQueue {

    /**
     * 队列元素
     */
    Object[] elements;
    /**
     * 队列容量
     */
    int capacity;

    /**
     * 队列头下标
     */
    int head;
    /**
     * 队列尾下标
     */
    int tail;

    public SimpleArrayQueue(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        head = tail = -1;
    }

    /**
     * 队尾入队
     *
     * @param element 元素
     * @return 成功返回true，队满返回false
     */
    public boolean enqueue(Object element) {
        if (tail - 1 == capacity) {
            // 队满
            return false;
        }
        ++tail;
        elements[tail] = element;
        if (head == -1) {
            head = 0;
        }
        return true;
    }

    /**
     * 队头出队
     *
     * @return 队头元素，空时抛异常
     */
    public Object dequeue() throws IllegalStateException {
        if (head == -1 || (head != 0 && head > tail)) {
            throw new IllegalStateException("SimpleArrayQueue队空");
        }
        Object element = elements[head];
        ++head;
        return element;
    }

}
