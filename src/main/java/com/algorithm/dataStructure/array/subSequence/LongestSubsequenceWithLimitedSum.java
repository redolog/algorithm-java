package com.algorithm.dataStructure.array.subSequence;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
 *
 * @author songhuilong001  @date 2023/3/18
 */
public class LongestSubsequenceWithLimitedSum {

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        int[] sortedPreSum = new int[n];
        int preSum = 0;
        // n*logn 复杂度，求子序列和，可以将原数组排序，求前缀和，可对有序的前缀和进行二分，进而逼近答案
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            sortedPreSum[i] = preSum;
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int maxSum = queries[i];
            // 此处仅需找到 <=maxSum 的最大前缀和位置，即可得到子序列最大长度（数组位置）
            ans[i] = findMaxIdxLessThanMaxSum(maxSum, sortedPreSum) + 1;
        }
        return ans;
    }

    /**
     * 由于 sortedPreSum 已经做了有序化，可使用二分来降低查询复杂度
     *
     * @param maxSum       当前答案最大边界值（包含）
     * @param sortedPreSum 有序的序列
     * @return 返回比maxSum小的最大值下标，找不到时返回-1
     */
    private int findMaxIdxLessThanMaxSum(int maxSum, int[] sortedPreSum) {
        int l = 0, r = sortedPreSum.length;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (sortedPreSum[mid] <= maxSum) {
                if (mid == sortedPreSum.length - 1 || sortedPreSum[mid + 1] > maxSum) {
                    return mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
