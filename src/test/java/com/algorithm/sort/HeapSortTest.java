package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {

    @Test
    public void heapSort() {
        int[] a = {0, 4, 5, 6, 3, 2, 1};
        HeapSort.heapSort(a);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6}, a);

        for (int i = 0; i < 100; i++) {
            int[] arr = ArrayUtils.createArrayByRandomLenAndVal(10 + i, 100 + i);
            int[] copied = ArrayUtils.copyArray(arr);
            HeapSort.heapSort(arr);
            Arrays.sort(copied);

            Assert.assertArrayEquals(arr, copied);
        }
    }
}