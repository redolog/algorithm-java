package com.algorithm.dataStructure.array.intersection;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntersectionOfTwoArraysIITest {

    @Test
    public void intersect() {
        IntersectionOfTwoArraysII service = new IntersectionOfTwoArraysII();
        assertArrayEquals(new int[]{2, 2}, service.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{4, 9}, service.intersect(new int[]{9, 4, 9, 8, 4}, new int[]{4, 9, 5}));
    }
}