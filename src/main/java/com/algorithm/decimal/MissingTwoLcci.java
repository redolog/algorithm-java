package com.algorithm.decimal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/missing-two-lcci/
 *
 * @author songhuilong  @date 2022/9/26
 */
public class MissingTwoLcci {

    static class GeometricProgression {
        public int[] missingTwo(int[] nums) {
            int n = nums.length,
                    // 数组补全后的和，由等比数列求和得出
                    allSum = (1 + n + 2) * (n + 2) / 2,
                    // 当前数组nums的数组和
                    currSum = Arrays.stream(nums).sum(),
                    // 补全后完整数组和 - 当前数组和 == 所求两个元素的和
                    diffSum = allSum - currSum,
                    // 取 diffSum 中间值
                    diffSumHalf = diffSum / 2,
                    // 当前nums小于 diffSumHalf 的和
                    currFirstHalfSum = Arrays.stream(nums).filter(num -> num <= diffSumHalf).sum(),
                    // x = 头一半所有数和 - 当前数组中头一半的和
                    x = IntStream.range(1, diffSumHalf + 1).sum() - currFirstHalfSum,
                    // y = 补全数列所有和-已有数列和-x
                    y = diffSum - x;
            return new int[]{x, y};
        }

        public int[] missingTwo2(int[] nums) {
            int n = nums.length,
                    // 数组补全后的和，由等比数列求和得出
                    allSum = (1 + n + 2) * (n + 2) / 2;
            // 当前数组nums的数组和
            int currSum = 0;
            for (int num : nums) {
                currSum += num;
            }
            // 补全后完整数组和 - 当前数组和 == 所求两个元素的和
            int diffSum = allSum - currSum,
                    // 取 diffSum 中间值
                    diffSumHalf = diffSum / 2;

            // 当前nums小于 diffSumHalf 的和
            int currFirstHalfSum = 0;
            for (int num : nums) {
                if (num <= diffSumHalf) {
                    currFirstHalfSum += num;
                }
            }
            // x = 头一半所有数和 - 当前数组中头一半的和
            int x = -currFirstHalfSum;
            for (int i = 1; i < diffSumHalf + 1; i++) {
                x += i;
            }
            // y = 补全数列所有和-已有数列和-x
            int y = diffSum - x;
            return new int[]{x, y};
        }
    }


    static class MapSolution {
        public int[] missingTwo(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            // fillCnt 表示往ans数组填充的数量，i表示 [1,n] 遍历指针，j表示存储指针
            int fillCnt = 2, i = 1;
            int[] ans = new int[2];
            while (fillCnt > 0) {
                if (!numSet.contains(i)) {
                    ans[2 - fillCnt] = i;
                    fillCnt--;
                }
                i++;
            }
            return ans;
        }
    }
}
