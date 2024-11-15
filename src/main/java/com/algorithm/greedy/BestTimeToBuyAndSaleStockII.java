package com.algorithm.greedy;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 *
 * @author songhuilong  @date 2024/11/15
 */
public class BestTimeToBuyAndSaleStockII {

    /**
     * 解决本题核心思路：
     * 只要头一天买第二天卖能赚钱，就交易
     * 重复上面这个过程
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                // 昨天买今天卖能赚钱，进行一次交易
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
