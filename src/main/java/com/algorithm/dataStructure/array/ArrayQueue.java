package com.algorithm.dataStructure.array;

/**
 * 用数据实现队列
 * 20:16:24 我: 构造函数指定容量
 * 20:16:36 我: 实现入队、出队方法
 * 20:16:48 我: 不考虑扩缩容
 * 20:16:56 我: 队列满、空直接抛异常
 *
 * @author DragonSong  @date 2021/3/22
 */
public class ArrayQueue {

    private int capacity;
    private int[] arr;
    private int pollIndex;
    private int pushIndex;
    private int size;

    public ArrayQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("容量必须为正数");
        }
        this.arr = new int[capacity];
        this.pollIndex = 0;
        this.pushIndex = 0;
        this.capacity = capacity;
        this.size = 0;
    }

    public void push(int element) {
        if (pushIndex == size) {
            throw new ArrayIndexOutOfBoundsException("队列已满");
        }
        arr[pushIndex] = element;
        pushIndex = pushIndex == capacity - 1 ? 0 : pushIndex + 1;
        size++;
    }

    public int poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("队列已经空了");
        }
        int originalPollIndex = pollIndex;
        pollIndex = pollIndex == arr.length - 1 ? 0 : pollIndex + 1;
        size--;
        return arr[originalPollIndex];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);
        queue.push(1);
        queue.push(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
