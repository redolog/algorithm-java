package com.algorithm.dataStructure.array;

/**
 * 连续子数组最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 *  
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author dragonsong  @date 2022/5/6
 * @link {https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/}
 */
public class MaxSubArraySum {

    /**
     * 组合、最值，动态规划！！！
     */

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            // pre > 0 时，表示前缀有正向收益，追加到和
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
