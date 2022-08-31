package com.algorithm.greedy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount/
 *
 * @author dragonsong  @date 2022/8/31
 */
public class MinimumCostOfBuyingCandiesWithDiscount {

    /**
     * 贪心的策略，我们优先买最贵的两个，就可以免费得到次贵的那个
     * 排序时间复杂度： O(n*logn)
     * 排序递归栈空间复杂度：O(logn)
     */
    public int minimumCost(int[] cost) {
        int n = cost.length;
        if (n <= 2) {
            return Arrays.stream(cost).sum();
        }
        Arrays.sort(cost);
        int ans = 0;
        for (int i = n - 1; i >= 0; i -= 3) {
            ans += cost[i];
            if (i - 1 >= 0) {
                ans += cost[i - 1];
            }

        }
        return ans;
    }
}
