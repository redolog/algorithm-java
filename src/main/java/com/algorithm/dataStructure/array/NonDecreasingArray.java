package com.algorithm.dataStructure.array;

/**
 * 665. 非递减数列
 * https://leetcode.cn/problems/non-decreasing-array/
 *
 * @author songhuilong  @date 2022/10/8
 */
public class NonDecreasingArray {

    /**
     * 1. 用例：4,2,1：出现超过两个严格递减对，则不可能只修改一个元素形成非递减数列
     * 2. 用例：3, 4, 2, 3：出现四元组 t[] 中，t1>t2 && t1>t3 同时，t0>t2
     * <p>
     * 当数组中出现 先升后降再升的趋势时，此时顶峰值需降低为谷底值，如果谷底值小于起点低值，说明峰值再怎么调整也无法满足【非递减数列】，因为t0必定>t1
     */
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, continuousStrictlyDecreasingCnt = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                continuousStrictlyDecreasingCnt++;
            }
            if (i + 2 < n && nums[i - 1] > nums[i + 1] && nums[i] > nums[i + 1] && nums[i] > nums[i + 2]) {
                return false;
            }
        }
        return continuousStrictlyDecreasingCnt < 2;
    }
}
