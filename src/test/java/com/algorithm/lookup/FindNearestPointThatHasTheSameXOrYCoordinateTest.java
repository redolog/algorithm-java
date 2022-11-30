package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindNearestPointThatHasTheSameXOrYCoordinateTest {

    @Test
    public void nearestValidPoint() {
        FindNearestPointThatHasTheSameXOrYCoordinate service = new FindNearestPointThatHasTheSameXOrYCoordinate();
        assertEquals(2, service.nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
        assertEquals(0, service.nearestValidPoint(3, 4, new int[][]{{3, 4}}));
        assertEquals(-1, service.nearestValidPoint(3, 4, new int[][]{{2, 3}}));
    }
}