package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountTargetNumberInSortedArrayTest {

    @Test
    public void search() {
        CountTargetNumberInSortedArray service = new CountTargetNumberInSortedArray();
        assertEquals(2, service.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertEquals(0, service.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}