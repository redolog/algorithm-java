package com.algorithm.dataStructure.array.intersection;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntersectionOfTwoArraysIITest {

    @Test
    public void intersect() {
        IntersectionOfTwoArraysII.MapSolution mapSolution = new IntersectionOfTwoArraysII.MapSolution();
        assertArrayEquals(new int[]{2, 2}, mapSolution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{4, 9}, mapSolution.intersect(new int[]{9, 4, 9, 8, 4}, new int[]{4, 9, 5}));
        IntersectionOfTwoArraysII.SortSolution sortSolution = new IntersectionOfTwoArraysII.SortSolution();
        assertArrayEquals(new int[]{2, 2}, sortSolution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{4, 9}, sortSolution.intersect(new int[]{9, 4, 9, 8, 4}, new int[]{4, 9, 5}));
    }
}