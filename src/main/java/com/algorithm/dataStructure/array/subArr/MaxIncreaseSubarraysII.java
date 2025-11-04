package com.algorithm.dataStructure.array.subArr;

import java.util.List;


/**
 * https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-ii/
 *
 * @author songhuilong  @date 2025/11/4
 */
public class MaxIncreaseSubarraysII {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        // 算法概述：
        // 1. 观察用例，符合题目要求的相邻递增子数组：
        // 1.1 相邻递增的两段子数组可合并为一段完整的递增子数组；此时k=len/2
        // 1.2 两段子数组相邻，但不可合并为一段完整递增数组；此时k=Min(len1, len2)，其中len1表示前段，len2表示后段
        // 2. 判断递增子数组，仅需维护段严格递增长度，出现下降趋势时，开启下一段
        // 3. 所求值为 Max(k1.1, k1.2)
        int n = nums.size();
        int len1 = 0;
        int len2 = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 后段计数
            len2++;
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // 数组已遍历完毕 || 出现递减趋势
                int kMax = Math.max(len2 / 2, Math.min(len1, len2));
                ans = Math.max(kMax, ans);
                // 前段更新为后段当前计数
                len1 = len2;
                // 后段重新计数
                len2 = 0;
            }
        }
        return ans;
    }
}
