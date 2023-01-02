package com.algorithm.dataStructure.queue.priorityQueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfOrdersInTheBacklogTest {

    @Test
    public void getNumberOfBacklogOrders() {
        NumberOfOrdersInTheBacklog service = new NumberOfOrdersInTheBacklog();
        assertEquals(6, service.getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}));
        assertEquals(999999984, service.getNumberOfBacklogOrders(new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}}));
    }
}