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
     * 表示下一个获取的下标
     */
    int head;
    /**
     * 队列尾下标
     * 表示下一个插入元素的下标
     */
    int tail;

    public SimpleArrayQueue(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    /**
     * 队尾入队
     *
     * @param element 元素
     * @return 成功返回true，队满返回false
     */
    public boolean enqueue(Object element) {
        if (tail == capacity) {
            // 队满
            System.err.println("队满");
            return false;
        }
        elements[tail] = element;
        ++tail;
        return true;
    }

    /**
     * 队头出队
     *
     * @return 队头元素，空时抛异常
     */
    public Object dequeue() throws IllegalStateException {
        if (head == tail) {
            throw new IllegalStateException("SimpleArrayQueue队空");
        }
        Object element = elements[head];
        ++head;
        return element;
    }

}
