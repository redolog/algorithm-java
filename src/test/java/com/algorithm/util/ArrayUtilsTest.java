package com.algorithm.util;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void createNearlyOrderedArray() {
        int size = 100000000;
        int swapTimes = 1000;
        int precision = swapTimes * 2;

        int[] orderedArray = ArrayUtils.createFullyOrderedArray(size);
        int[] nearlyOrderedArray = ArrayUtils.createNearlyOrderedArray(size, swapTimes);

        Assert.assertTrue(ArrayUtils.nearlyEquals(precision, orderedArray, nearlyOrderedArray));
    }
}