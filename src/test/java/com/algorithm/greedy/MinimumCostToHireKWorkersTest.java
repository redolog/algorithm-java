package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumCostToHireKWorkersTest {

    @Test
    public void mincostToHireWorkers() {
        MinimumCostToHireKWorkers service = new MinimumCostToHireKWorkers();
        double delta = Math.pow(10, -5);
        assertEquals(105.00000, service.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2), delta);
        assertEquals(30.66667, service.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3), delta);
    }
}