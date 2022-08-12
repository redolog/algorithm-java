package com.algorithm.company.advance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinQueueTimeTest {

    @Test
    public void testMinQueueTime() {
        MinQueueTime service = new MinQueueTime();
        assertEquals(12, service.queueTime(new int[]{5, 3, 4}, 1));
        assertEquals(5, service.queueTime(new int[]{5, 3, 4}, 10));
        assertEquals(10, service.queueTime(new int[]{10, 2, 3, 3}, 2));
        assertEquals(12, service.queueTime(new int[]{2, 3, 10}, 2));
    }
}