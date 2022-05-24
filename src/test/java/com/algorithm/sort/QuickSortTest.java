package com.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void quickSort() {
        int[] a = {4, 5, 6, 3, 2, 1};
        QuickSort.quickSort(a);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);
        int[] b = {1, 2, 2};
        QuickSort.quickSort(b);
        Assert.assertArrayEquals(new int[]{1, 2, 2}, b);
        int[] c = {1, 2, 3, 2};
        QuickSort.quickSort(c);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 3}, c);
        int[] d = {1, 2, 2, 3, 2};
        QuickSort.quickSort(d);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 2, 3}, d);
        int[] e = {1, 3, 3, 2, 3};
        QuickSort.quickSort(e);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 3}, e);
        int[] f = {2, 3, 3, 1, 3};
        QuickSort.quickSort(f);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 3}, f);
    }
}