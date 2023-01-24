package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QueriesOnNumberOfPointsInsideCircleTest {

    @Test
    public void countPoints() {
        QueriesOnNumberOfPointsInsideCircle service = new QueriesOnNumberOfPointsInsideCircle();
        assertArrayEquals(new int[]{3, 2, 2}, service.countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}}, new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}}));
        assertArrayEquals(new int[]{2, 3, 2, 4}, service.countPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, new int[][]{{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}}));
    }
}