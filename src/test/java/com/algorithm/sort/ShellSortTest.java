package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ShellSortTest {

    @Test
    public void shellSort() {
        ShellSort shellSort = new ShellSort();

        int[] a = {5,4, 6, 3, 2, 1};
        shellSort.shellSort(a);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);

        for (int i = 0; i < 100; i++) {
            int[] arr = ArrayUtils.createArrayByRandomLenAndVal(10 + i, 100 + i);
            int[] copied = ArrayUtils.copyArray(arr);
            Arrays.sort(copied);

            shellSort.shellSort(arr);

            Assert.assertArrayEquals(arr, copied);
        }

    }
}