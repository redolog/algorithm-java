package com.algorithm.dataStructure.queue;

import org.junit.Assert;
import org.junit.Test;

public class SimpleArrayQueueTest {

    @Test
    public void enqueue() {
        SimpleArrayQueue queue = new SimpleArrayQueue(3);
        String str1 = "第一个元素";
        queue.enqueue(str1);
        String str2 = "第二个元素";
        queue.enqueue(str2);
        String str3 = "第三个元素";
        Assert.assertTrue(queue.enqueue(str3));
        String str4 = "第四个元素";
        Assert.assertFalse(queue.enqueue(str4));

        Assert.assertEquals(str1,queue.dequeue());
        Assert.assertEquals(str2,queue.dequeue());
        Assert.assertEquals(str3,queue.dequeue());
    }

    @Test
    public void dequeue() {
        SimpleArrayQueue queue = new SimpleArrayQueue(3);

        Assert.assertThrows(IllegalStateException.class, queue::dequeue);
    }
}