package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertPositionTest {

    @Test
    public void searchInsert() {
        SearchInsertPosition service = new SearchInsertPosition();
        assertEquals(2, service.searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, service.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, service.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}