package com.algorithm.dataStructure.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxQueueTest {

    @Test
    public void testMaxQueue() {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);

        assertEquals(2, maxQueue.max_value());

        assertEquals(1, maxQueue.pop_front());

        assertEquals(2, maxQueue.max_value());
    }
}