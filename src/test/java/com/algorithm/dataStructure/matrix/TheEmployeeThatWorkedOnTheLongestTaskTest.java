package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TheEmployeeThatWorkedOnTheLongestTaskTest {

    @Test
    public void hardestWorker() {
        TheEmployeeThatWorkedOnTheLongestTask service = new TheEmployeeThatWorkedOnTheLongestTask();
        assertEquals(1, service.hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}}));
        assertEquals(3, service.hardestWorker(26, new int[][]{{1, 1}, {3, 7}, {2, 12}, {7, 17}}));
        assertEquals(0, service.hardestWorker(2, new int[][]{{0, 10}, {1, 20}}));
    }
}