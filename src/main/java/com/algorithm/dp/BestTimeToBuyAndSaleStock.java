package com.algorithm.dp;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * @author dragonsong  @date 2022/7/20
 */
public class BestTimeToBuyAndSaleStock {

    /**
     * |   要素  |   |
     * |  ----  | ----  |
     * |  状态表示  | `dp[i][0]`表示当前能买入的最低价格、`dp[i][1]`表示当前天卖出的价格；  |
     * |  阶段划分  | 子序列结尾；  |
     * |  转移方程  | `dp[i]=Min(prices(0,i)) `dp[i][1]=prices[i]`  |
     * |  边界  | `dp[0]=prices[0]`  |
     * |  目标  | `Max(prices[i]-dp[i]) (0<=i<n)`  |
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp数组存储当前时刻前买入的最低价格
        int[] dp = new int[n];
        dp[0] = prices[0];
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);

            // 判断当前时刻卖出是否划算？
            if (prices[i] - dp[i] > ans) {
                ans = prices[i] - dp[i];
            }
        }
        return ans;
    }

    /**
     * 使用滚动数组优化：只需维护窗口内的最低买入价格即可
     */
    static class ScrollArray {
        /*
         * 执行用时：
         * 2 ms
         * , 在所有 Java 提交中击败了
         * 58.30%
         * 的用户
         * 内存消耗：
         * 58.2 MB
         * , 在所有 Java 提交中击败了
         * 5.05%
         * 的用户
         * 通过测试用例：
         * 211 / 211
         */

        public int maxProfit(int[] prices) {
            int minBuyPrice = prices[0];
            int ans = 0;

            for (int i = 1; i < prices.length; i++) {
                minBuyPrice = Math.min(minBuyPrice, prices[i]);
                ans = Math.max(prices[i] - minBuyPrice, ans);
            }
            return ans;
        }
    }
}
