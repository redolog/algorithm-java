package com.algorithm.math;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircleAndRectangleOverlappingTest {

    @Test
    public void checkOverlap() {
        CircleAndRectangleOverlapping service = new CircleAndRectangleOverlapping();
        assertTrue(service.checkOverlap(1, 0, 0, 1, -1, 3, 1));
        assertTrue(service.checkOverlap(1, 0, 0, -1, 0, 0, 1));
        assertTrue(service.checkOverlap(1, 1, 1, -3, -3, 3, 3));
        assertFalse(service.checkOverlap(1, 1, 1, 1, -3, 2, -1));
    }
}