package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void quickSort() {
//        int[] a = {4, 5, 1, 3, 2, 6};
//        QuickSort.quickSortThreeWays(a);
//        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);
//        int[] b = {1, 2, 2};
//        QuickSort.quickSortThreeWays(b);
//        Assert.assertArrayEquals(new int[]{1, 2, 2}, b);
//        int[] c = {1, 2, 3, 2};
//        QuickSort.quickSortThreeWays(c);
//        Assert.assertArrayEquals(new int[]{1, 2, 2, 3}, c);
//        int[] d = {1, 2, 2, 3, 2};
//        QuickSort.quickSort(d);
//        Assert.assertArrayEquals(new int[]{1, 2, 2, 2, 3}, d);
//        int[] e = {1, 3, 3, 2, 3};
//        QuickSort.quickSort(e);
//        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 3}, e);
//        int[] f = {2, 3, 3, 1, 3};
//        QuickSort.quickSort(f);
//        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 3}, f);

        for (int i = 0; i < 20; i++) {
            int[] arr = ArrayUtils.createArrayByRandomLenAndVal(10000000 + i, 100 + i);
            int[] copied = ArrayUtils.copyArray(arr);
            int[] copied2 = ArrayUtils.copyArray(arr);
            ArrayUtils.testSort("com.algorithm.sort.QuickSort","quickSort", arr);
            ArrayUtils.testSort("com.algorithm.sort.QuickSort","quickSortThreeWays", copied2);
            ArrayUtils.testSort("java.util.Arrays","sort",copied);

            Assert.assertArrayEquals(arr, copied);
        }
    }
}