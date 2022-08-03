package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderlyQueueTest {

    @Test
    public void orderlyQueue() {
        OrderlyQueue service = new OrderlyQueue();
        assertEquals("acb", service.orderlyQueue("cba", 1));
        assertEquals("aaabc", service.orderlyQueue("baaca", 3));
    }
}