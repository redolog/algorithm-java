package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTest {

    FindMinimumInRotatedSortedArray service = new FindMinimumInRotatedSortedArray();

    @Test
    public void findMin() {
        Assert.assertEquals(1, service.findMin(new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(0, service.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assert.assertEquals(1, service.findMin(new int[]{2, 1}));

    }
}