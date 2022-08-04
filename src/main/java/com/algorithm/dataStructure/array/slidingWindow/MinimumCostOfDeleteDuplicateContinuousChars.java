package com.algorithm.dataStructure.array.slidingWindow;

/**
 * codility原题大意：
 * 给定一个str
 * 给定一个cost数组，数组对应下标数值表示，删除该字符的成本
 * 要求删除字符串中紧邻的重复字符，并且求最小成本
 */
public class MinimumCostOfDeleteDuplicateContinuousChars {
    // 优化后的写法
    public int miniCost(String str, int[] cost) {
        int n = str.length();
        int ans = 0;
        for (int i = 0; i + 1 < n; i++) {
            int sum = cost[i];
            int maxCost = cost[i];
            while (i + 1 < n && str.charAt(i) == str.charAt(i + 1)) {
                maxCost = Math.max(maxCost, cost[i + 1]);
                sum += cost[i + 1];
                i++;
            }
            ans += sum == maxCost ? 0 : sum - maxCost;
        }
        return ans;
    }

    // 面试时的写法
    public int miniCost2(String str, int[] cost) {
        int ans = 0;
        int n = str.length();

        int l = 0, r;
        while (l < n) {
            r = l + 1;
            while (r < n && str.charAt(r) != str.charAt(l)) {
                l++;
                r++;
            }
            int maxCost = cost[l];
            while (r < n && str.charAt(r) == str.charAt(r - 1)) {
                maxCost = Math.max(maxCost, cost[r]);
                r++;
            }
            for (int i = l; i < r; i++) {
                if (cost[i] != maxCost) {
                    ans += cost[i];
                }
            }
            l = r;
        }

        return ans;
    }
}
