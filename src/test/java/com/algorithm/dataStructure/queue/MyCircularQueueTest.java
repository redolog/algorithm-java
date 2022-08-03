package com.algorithm.dataStructure.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularQueueTest {

    @Test
    public void testMyCircularQueue() {
        MyCircularQueue queue = new MyCircularQueue(3);
        assertTrue(queue.enQueue(2));
        assertEquals(2, queue.Rear());
        assertEquals(2, queue.Front());
        assertTrue(queue.deQueue());
        assertEquals(-1, queue.Front());
        assertFalse(queue.deQueue());
        assertEquals(-1, queue.Front());
        assertTrue(queue.enQueue(4));
        assertTrue(queue.enQueue(2));
        assertTrue(queue.enQueue(2));
        assertFalse(queue.enQueue(3));

        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        assertTrue(circularQueue.enQueue(1));
        assertTrue(circularQueue.enQueue(2));
        assertTrue(circularQueue.enQueue(3));
        assertFalse(circularQueue.enQueue(4));
        assertEquals(3, circularQueue.Rear());
        assertTrue(circularQueue.isFull());
        assertTrue(circularQueue.deQueue());
        assertTrue(circularQueue.enQueue(4));
        assertEquals(4, circularQueue.Rear());
    }
}