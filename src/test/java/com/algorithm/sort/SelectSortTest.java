package com.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class SelectSortTest {

    @Test
    public void selectSort() {
        int[] a = {4, 5, 6, 3, 2, 1};
        SelectSort.selectSort(a);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);
    }
}