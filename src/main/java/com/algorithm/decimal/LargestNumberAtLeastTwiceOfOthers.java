package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/largest-number-at-least-twice-of-others/
 *
 * @author songhuilong001  @date 2022/12/4
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        int n = nums.length, first = -1, second = -1;
        for (int i = 0; i < n; i++) {
            if (first == -1) {
                first = i;
                continue;
            }

            int num = nums[i];
            if (num > nums[first]) {
                second = first;
                first = i;
            } else if (num < nums[first] && (second == -1 || num > nums[second])) {
                second = i;
            }
        }
        return second == -1 || nums[first] >= 2 * nums[second] ? first : -1;
    }

    public int dominantIndex2(int[] nums) {
        int n = nums.length,
                // 记录最大值、次大值 数值
                first = -1, second = -1,
                // 记录答案下标
                ans = -1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num > first) {
                second = first;
                first = num;
                ans = i;
            } else if (num < first && num > second) {
                second = num;
            }
        }
        return first >= 2 * second ? ans : -1;
    }
}
