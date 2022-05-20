package com.algorithm.dataStructure.queue;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListQueueTest {

    @Test
    public void enqueue() {
        LinkedListQueue queue = new LinkedListQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertTrue(queue.enqueue(3));
        Assert.assertFalse(queue.enqueue(4));

        Assert.assertEquals(1, queue.dequeue());
        Assert.assertEquals(2, queue.dequeue());

        Assert.assertTrue(queue.enqueue(1));
        Assert.assertTrue(queue.enqueue(2));
        Assert.assertFalse(queue.enqueue(3));
    }

    @Test
    public void dequeue() {
    }
}