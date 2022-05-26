package com.algorithm.dataStructure.queue;

import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListQueueTest {

    @Test
    public void enqueue() {
        SingleLinkedListQueue queue = new SingleLinkedListQueue(2);
        queue.enqueue(1);
        Assert.assertTrue(queue.enqueue(2));
        Assert.assertFalse( queue.enqueue(3));

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        Assert.assertThrows(IllegalStateException.class, queue::dequeue);
    }
}