package com.algorithm.dataStructure.array;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MergeTwoSortedArrayTest {

    MergeTwoSortedArray service;

    @Before
    public void setUp() throws Exception {
        service = new MergeTwoSortedArray();
    }

    @Test
    public void merge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        service.back2Front(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}