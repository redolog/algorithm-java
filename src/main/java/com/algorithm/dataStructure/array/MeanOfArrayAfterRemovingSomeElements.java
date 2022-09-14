package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 *
 * @author songhuilong  @date 2022/9/14
 */
public class MeanOfArrayAfterRemovingSomeElements {

    public double trimMean(int[] arr) {
        int n = arr.length, sum = 0, skip = n / 20;
        Arrays.sort(arr);

        for (int i = skip; i < n - skip; i++) {
            sum += arr[i];
        }
        return (double) sum / (n * 0.9);
    }
}
