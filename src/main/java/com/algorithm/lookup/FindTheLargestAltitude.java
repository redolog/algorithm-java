package com.algorithm.lookup;

/**
 * https://leetcode.cn/problems/find-the-highest-altitude/
 *
 * @author songhuilong001  @date 2022/11/19
 */
public class FindTheLargestAltitude {

    /**
     * 时间：O(n)
     * 空间：O(1)
     */
    public int largestAltitude(int[] gain) {
        // 起点海拔是0，所求最高海拔最小是0
        int prev = 0, ans = 0;
        for (int i = 0; i < gain.length; i++) {
            gain[i] += prev;
            ans = Math.max(ans, gain[i]);
            prev = gain[i];
        }
        return ans;
    }

}
