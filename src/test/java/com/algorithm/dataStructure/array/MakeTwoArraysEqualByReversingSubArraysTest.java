package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MakeTwoArraysEqualByReversingSubArraysTest {

    @Test
    public void canBeEqual() {
        MakeTwoArraysEqualByReversingSubArrays.Count count = new MakeTwoArraysEqualByReversingSubArrays.Count();
        assertTrue(count.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        assertTrue(count.canBeEqual(new int[]{7}, new int[]{7}));
        assertFalse(count.canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));

        MakeTwoArraysEqualByReversingSubArrays.Sort sort = new MakeTwoArraysEqualByReversingSubArrays.Sort();
        assertTrue(sort.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        assertTrue(sort.canBeEqual(new int[]{7}, new int[]{7}));
        assertFalse(sort.canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));
    }
}