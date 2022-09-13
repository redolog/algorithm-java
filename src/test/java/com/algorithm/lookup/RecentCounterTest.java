package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecentCounterTest {

    @Test
    public void ping() {
        RecentCounter.TreeMapSolution treeMapSolution = new RecentCounter.TreeMapSolution();
        assertEquals(1, treeMapSolution.ping(1));
        assertEquals(2, treeMapSolution.ping(100));
        assertEquals(3, treeMapSolution.ping(3001));
        assertEquals(3, treeMapSolution.ping(3002));
        RecentCounter.QueueSolution queueSolution = new RecentCounter.QueueSolution();
        assertEquals(1, queueSolution.ping(1));
        assertEquals(2, queueSolution.ping(100));
        assertEquals(3, queueSolution.ping(3001));
        assertEquals(3, queueSolution.ping(3002));
    }
}