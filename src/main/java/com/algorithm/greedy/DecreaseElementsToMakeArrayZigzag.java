package com.algorithm.greedy;

/**
 * https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
 *
 * @author songhuilong  @date 2023/2/27
 */
public class DecreaseElementsToMakeArrayZigzag {

    public int movesToMakeZigzag(int[] nums) {
        return Math.min(calc(nums, true), calc(nums, false));
    }

    /**
     * 关键题干，一次操作：将数字减一。
     * 那么给定偶数、奇数下标为波峰时，只需要下降对应的奇数、偶数左右的值，下降时，降到 x-1 的位置即可
     *
     * @param nums        源数组
     * @param evenGreater true：偶数下标比奇数下标大，false：奇数下标比偶数下标大
     * @return 对应情况下元素需挪动的次数
     */
    public int calc(int[] nums, boolean evenGreater) {
        int n = nums.length;
        int steps = 0,
                // 偶数下标为波峰时，从1开始判断与左右的关系；反之，从0开始；
                i = evenGreater ? 1 : 0;
        for (; i < n; i += 2) {
            // i当前位置，应该降低到左右波峰的较低-1
            int neighborPeakMin = Integer.MAX_VALUE;
            if (i - 1 >= 0 && nums[i - 1] <= nums[i]) {
                neighborPeakMin = Math.min(neighborPeakMin, nums[i - 1]);
            }
            if (i + 1 < n && nums[i + 1] <= nums[i]) {
                neighborPeakMin = Math.min(neighborPeakMin, nums[i + 1]);
            }
            // MAX_VALUE 说明当前值已经比左右都低了
            steps += neighborPeakMin == Integer.MAX_VALUE ? 0 : nums[i] - neighborPeakMin + 1;
        }
        return steps;
    }

}
