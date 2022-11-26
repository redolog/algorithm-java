package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/
 *
 * @author songhuilong001  @date 2022/11/27
 */
public class CheckIfArrayIsSortedAndRotated {

    /**
     * 最大值的下一项只能是：最大值（等值元素）、最小值（被轮转过来的最小值）、空（序列结尾）
     * 最大值的上一项只能是：最大值（等值元素）、次大值（升序的上一项）、空（其余元素都被轮转到了后面）
     * 最小值的下一项只能是：最小值（等值元素）、次小值（升序的下一项）、空（只有第一个最小元素轮转到了最后）
     * 时间：O(n)
     * 空间：O(1)
     */
    public boolean check(int[] nums) {
        int max = 1, secondMax = 1, min = 100, secondMin = 100, n = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max == min) {
            return true;
        }
        for (int num : nums) {
            if (num > min) {
                secondMin = Math.min(secondMin, num);
            }
            if (num < max) {
                secondMax = Math.max(secondMax, num);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                // 最大值下一项
                if (i < n - 1 && nums[i + 1] != max && nums[i + 1] != min) {
                    return false;
                }
                // 最大值上一项
                if (i > 0 && nums[i - 1] != max && nums[i - 1] != secondMax) {
                    return false;
                }
            }
            if (nums[i] == min) {
                // 最小值下一项
                if (i < n - 1 && nums[i + 1] != min && nums[i + 1] != secondMin) {
                    return false;
                }
            }
        }
        return true;
    }
}
