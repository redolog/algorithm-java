package com.algorithm.dataStructure.queue;

import org.junit.Assert;
import org.junit.Test;

public class CircularArrayQueueTest {

    @Test
    public void enqueue() {
        // 这个实现下capacity-1为真实容量
        CircularArrayQueue queue = new CircularArrayQueue(3);
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