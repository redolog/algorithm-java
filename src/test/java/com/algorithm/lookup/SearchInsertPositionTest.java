package com.algorithm.lookup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchInsertPositionTest {

    SearchInsertPosition service;

    @Before
    public void init() {
        service = new SearchInsertPosition();
    }

    @Test
    public void searchInsert() {
        Assert.assertEquals(2, service.searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assert.assertEquals(1, service.searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assert.assertEquals(4, service.searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assert.assertEquals(0, service.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}