package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindPivotIndexTest {

    @Test
    public void pivotIndex() {
        FindPivotIndex service = new FindPivotIndex();
        assertEquals(3, service.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(-1, service.pivotIndex(new int[]{1, 2, 3}));
        assertEquals(0, service.pivotIndex(new int[]{2, 1, -1}));
        assertEquals(-1, service.pivotIndex(new int[]{-1, -1, -1, 1, 1, 1}));
    }
}