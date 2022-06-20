package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayIITest {

    FindMinimumInRotatedSortedArrayII service = new FindMinimumInRotatedSortedArrayII();

    @Test
    public void minArray() {
        Assert.assertEquals(1, service.minArray(new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(0, service.minArray(new int[]{2, 2, 2, 0, 1}));
        Assert.assertEquals(0, service.minArray(new int[]{1, 0, 1, 1, 1, 1, 1}));
        Assert.assertEquals(1, service.minArray(new int[]{1, 1, 1, 1, 1, 1, 1}));

    }
}