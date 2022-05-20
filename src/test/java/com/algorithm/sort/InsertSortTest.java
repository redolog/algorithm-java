package com.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class InsertSortTest {

    @Test
    public void insertSort() {
        int[] a = {4, 5, 6, 3, 2, 1};
        InsertSort.insertSort(a);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);
    }
}