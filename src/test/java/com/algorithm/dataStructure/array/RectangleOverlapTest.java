package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleOverlapTest {

    @Test
    public void isRectangleOverlap() {
        RectangleOverlap service = new RectangleOverlap();
        assertTrue(service.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        assertFalse(service.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        assertFalse(service.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3}));
    }
}