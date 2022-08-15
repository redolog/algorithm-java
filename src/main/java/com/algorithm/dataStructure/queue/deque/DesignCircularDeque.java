package com.algorithm.dataStructure.queue.deque;

/**
 * 641. Design Circular Deque
 * Design your implementation of the circular double-ended queue (deque).
 * <p>
 * Implement the MyCircularDeque class:
 * <p>
 * MyCircularDeque(int k) Initializes the deque with a maximum size of k.
 * boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
 * int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
 * int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
 * boolean isEmpty() Returns true if the deque is empty, or false otherwise.
 * boolean isFull() Returns true if the deque is full, or false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * Output
 * [null, true, true, true, false, 2, true, true, true, 4]
 * <p>
 * Explanation
 * MyCircularDeque myCircularDeque = new MyCircularDeque(3);
 * myCircularDeque.insertLast(1);  // return True
 * myCircularDeque.insertLast(2);  // return True
 * myCircularDeque.insertFront(3); // return True
 * myCircularDeque.insertFront(4); // return False, the queue is full.
 * myCircularDeque.getRear();      // return 2
 * myCircularDeque.isFull();       // return True
 * myCircularDeque.deleteLast();   // return True
 * myCircularDeque.insertFront(4); // return True
 * myCircularDeque.getFront();     // return 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.
 * <p>
 * https://leetcode.cn/problems/design-circular-deque/
 *
 * @author dragonsong  @date 2022/8/15
 */
public class DesignCircularDeque {

    static class LinkedCircularDeque {

        // dummy节点，方便首尾操作
        Node head, tail;

        int capacity;
        int size;

        public LinkedCircularDeque(int k) {
            this.capacity = k;
            this.size = 0;
            head = new Node(Integer.MAX_VALUE);
            tail = new Node(Integer.MAX_VALUE);
            head.next = head.prev = tail;
            tail.prev = tail.next = head;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            Node newNode = new Node(value);
            head.next.prev = newNode;
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;
            ++size;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            Node newNode = new Node(value);
            tail.prev.next = newNode;
            newNode.prev = tail.prev;
            newNode.next = tail;
            tail.prev = newNode;
            ++size;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head.next.next.prev = head;
            head.next = head.next.next;
            --size;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            --size;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return head.next.val;
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return tail.prev.val;
        }

        static class Node {
            Node prev, next;
            int val;

            public Node(int val) {
                this.val = val;
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    static class ArrayCircularDeque {

        int[] arr;
        int head;
        int tail;
        int capacity;
        int size;

        public ArrayCircularDeque(int k) {
            arr = new int[k];
            capacity = k;
            size = 0;
            head = tail = -1;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                head = tail = 0;
            } else {
                head = head == 0 ? capacity - 1 : head - 1;
            }
            arr[head] = value;
            ++size;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                head = tail = 0;
            } else {
                tail = tail == capacity - 1 ? 0 : tail + 1;
            }
            arr[tail] = value;
            ++size;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = head == capacity - 1 ? 0 : head + 1;
            --size;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = tail == 0 ? capacity - 1 : tail - 1;
            --size;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return arr[head];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    static class ArrayCircularDeque2 {

        int[] arr;
        int head;
        int tail;
        int capacity;

        public ArrayCircularDeque2(int k) {
            capacity = k + 1;
            arr = new int[capacity];
            head = tail = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = (head - 1 + capacity) % capacity;
            arr[head] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            arr[tail] = value;
            tail = (tail + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = (tail - 1 + capacity) % capacity;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return arr[head];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[(tail - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return (tail + 1) % capacity == head;
        }
    }
}
