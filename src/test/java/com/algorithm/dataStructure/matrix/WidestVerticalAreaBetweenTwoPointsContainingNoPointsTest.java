package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPointsTest {

    @Test
    public void maxWidthOfVerticalArea() {
        WidestVerticalAreaBetweenTwoPointsContainingNoPoints service = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
        assertEquals(1, service.maxWidthOfVerticalArea(new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}}));
        assertEquals(3, service.maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }
}