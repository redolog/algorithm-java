package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckArrayFormationThroughConcatenationTest {

    @Test
    public void canFormArray() {
        CheckArrayFormationThroughConcatenation service = new CheckArrayFormationThroughConcatenation();
        assertTrue(service.canFormArray(new int[]{15, 8}, new int[][]{{88}, {15}}));
        assertTrue(service.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
        assertFalse(service.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
    }
}