package com.algorithm.dataStructure.queue;

/**
 * 环形数组队列
 *
 * @author dragonsong  @date 2022/5/19
 */
public class CircularArrayQueue {

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

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity + 1;
        elements = new Object[capacity + 1];
        // 默认队空
        head = tail = 0;
    }

    /**
     * 队尾入队
     *
     * @param element 元素
     * @return 成功返回true，队满返回false
     */
    public boolean enqueue(Object element) {
        // 队满 (tail+1)%capacity==head
        // 搬移数组元素有O(n)的开销，使用环形数组优化
        // tail 追上head说明队列满了
        // tail指向的是下一个元素插入的位置，永远会有一个空位
        if ((tail + 1) % capacity == head) {
            System.err.println("队满");
            return false;
        }
        elements[tail] = element;
        // tail不停后移
        tail = (tail + 1) % capacity;
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
        head = (head + 1) % capacity;
        return element;
    }

}
