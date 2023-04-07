package com.algorithm.decimal;

/**
 * <a href="https://leetcode.cn/problems/find-n-unique-integers-sum-up-to-zero/submissions/">1304. 和为零的 N 个不同整数</a>
 *
 * @author songhuilong  @date 2023/4/7
 */
public class FindNUniqueIntegersSumUpToZero {

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            // arr[i]+arr[n-i-1]==0 
            if (i < n / 2) {
                // 偏移一个远大于 1 <= n <= 1000 的值
                ans[i] = -i + 10000;
            } else {
                ans[i] = -ans[n - i - 1];
            }
        }
        return ans;
    }
}
