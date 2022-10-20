package com.algorithm.decimal;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/sum-of-unique-elements/
 *
 * @author songhuilong  @date 2022/10/20
 */
public class SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {
        // @formatter:off
        // 时间空间均O(n)
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(1))
                .map(Map.Entry::getKey)
                .reduce(Integer::sum)
                .orElse(0);
        // @formatter:on
    }
}
