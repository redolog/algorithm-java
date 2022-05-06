package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxSubArraySumTest {

    MaxSubArraySum service;

    @Before
    public void setUp() throws Exception {
        service = new MaxSubArraySum();
    }

    @Test
    public void maxSubArray() {
        Assert.assertEquals(service.maxSubArray(new int[]{4, -1, 2, 1}), 6);

    }
}