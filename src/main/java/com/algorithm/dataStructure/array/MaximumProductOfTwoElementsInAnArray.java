package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 *
 * @author dragonsong  @date 2022/8/26
 */
public class MaximumProductOfTwoElementsInAnArray {

    /**
     * 先找到最大值位置
     * 再找次大值
     * <p>
     * 时间复杂度，整体遍历两次数组，O(n)
     * 空间复杂度，无额外空间占用，O(1)
     */
    public int maxProduct(int[] nums) {
        int maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIdx && nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return (nums[maxIdx] - 1) * (secondMax - 1);
    }

    public int maxProduct2(int[] nums) {
        int max = 0, secondMax = 0;
        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return (max - 1) * (secondMax - 1);
    }
}
