package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class RemoveElementTest {

    RemoveElement service;

    @Before
    public void init() {
        service = new RemoveElement();
    }

    @Test
    public void removeElement() {
        int[] nums = {3, 2, 2, 3};
        service.removeElement(nums, 3);
        System.out.println(Arrays.toString(nums));

        Assert.assertEquals(2, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }
}