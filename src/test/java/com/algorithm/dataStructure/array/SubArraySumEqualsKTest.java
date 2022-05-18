package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

public class SubArraySumEqualsKTest {

    @Test
    public void subarraySumPreSumTest() {
        Assert.assertEquals(2,SubArraySumEqualsK.subarraySumPreSum(new int[]{1,1,1},2));
        Assert.assertEquals(2,SubArraySumEqualsK.subarraySumPreSum(new int[]{1,2,3},3));
        Assert.assertEquals(0,SubArraySumEqualsK.subarraySumPreSum(new int[]{1},0));
        Assert.assertEquals(2,SubArraySumEqualsK.subarraySumPreSumMap(new int[]{1,1,1},2));
        Assert.assertEquals(2,SubArraySumEqualsK.subarraySumPreSumMap(new int[]{1,2,3},3));
        Assert.assertEquals(0,SubArraySumEqualsK.subarraySumPreSumMap(new int[]{1},0));
    }
}