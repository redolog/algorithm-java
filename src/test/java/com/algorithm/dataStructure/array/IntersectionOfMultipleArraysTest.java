package com.algorithm.dataStructure.array;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class IntersectionOfMultipleArraysTest {

    @Test
    public void intersection() {
        IntersectionOfMultipleArrays service = new IntersectionOfMultipleArrays();
        assertTrue(CollectionUtils.equals(Arrays.asList(3, 4), service.intersection(new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), service.intersection(new int[][]{{3, 1, 2}, {4, 5, 6}})));
    }
}