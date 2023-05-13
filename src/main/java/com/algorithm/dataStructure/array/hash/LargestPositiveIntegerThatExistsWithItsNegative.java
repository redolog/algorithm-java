package com.algorithm.dataStructure.array.hash;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/
 *
 * @author songhuilong001  @date 2023/5/13
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {

    public int findMaxK(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        return Arrays.stream(nums)
                .filter(num -> num > 0 && set.contains(-num))
                .max()
                .orElse(-1);

    }
}
