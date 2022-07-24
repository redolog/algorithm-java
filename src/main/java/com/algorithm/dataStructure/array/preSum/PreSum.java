package com.algorithm.dataStructure.array.preSum;

/**
 * 前缀和模板
 * 是一种对数组预处理的技巧
 * <p>
 * preSum[i]= sum(num[0,i]) ，即前缀和数组 preSum 中存储i元素以及之前所有元素之和
 * <p>
 * 适用于数组求范围和的情况
 *
 * @author dragonsong  @date 2022/7/24
 */
public class PreSum {
    /**
     * 前缀和
     */
    int[] sum;

    public PreSum(int[] nums) {
        assert nums != null;
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    /**
     * 范围求和
     *
     * @param left  左闭区间
     * @param right 右闭区间
     * @return nums[left, right] 和
     */
    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }

}
