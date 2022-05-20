package com.algorithm.dataStructure.queue;

/**
 * SimpleArrayQueue 中数组只能使用一次，MoveArrayQueue实现数组元素重复使用
 *
 * @author dragonsong  @date 2022/5/19
 */
public class MoveArrayQueue {

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

    public MoveArrayQueue(int capacity) {
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
            if (head == 0) {
                System.err.println("队满");
                return false;
            }
            // head != 0 说明数组前方有了空隙，数据需要搬移
            // tail下标没有数据，因此搬移范围为：[head,tail) -> [0,tail-head)
            // same as System.arraycopy
            for (int i = head; i < tail; i++) {
                elements[i - head] = elements[i];
            }
            tail -= head;
            head = 0;
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
