package com.algorithm.lookup.bsearch;

/**
 * 1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * <p>
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * <p>
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * <p>
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
 * 输出：3
 * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
 * 现在需要制作 3 束花，每束只需要 1 朵。
 * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
 * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
 * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
 * 示例 2：
 * <p>
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
 * 输出：-1
 * 解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
 * 示例 3：
 * <p>
 * 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * 输出：12
 * 解释：要制作 2 束花，每束需要 3 朵。
 * 花园在 7 天后和 12 天后的情况如下：
 * 7 天后：[x, x, x, x, _, x, x]
 * 可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
 * 12 天后：[x, x, x, x, x, x, x]
 * 显然，我们可以用不同的方式制作两束花。
 * 示例 4：
 * <p>
 * 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1
 * 输出：1000000000
 * 解释：需要等 1000000000 天才能采到花来制作花束
 * 示例 5：
 * <p>
 * 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * bloomDay.length == n
 * 1 <= n <= 10^5
 * 1 <= bloomDay[i] <= 10^9
 * 1 <= m <= 10^6
 * 1 <= k <= n
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-days-to-make-m-bouquets/
 *
 * @author dragonsong  @date 2022/7/26
 */
public class MinimumNumberOfDaysToMakeMBouquets {

    /*
     * 执行用时：
     * 18 ms
     * , 在所有 Java 提交中击败了
     * 67.87%
     * 的用户
     * 内存消耗：
     * 49.7 MB
     * , 在所有 Java 提交中击败了
     * 41.11%
     * 的用户
     * 通过测试用例：
     * 91 / 91
     */

    public int minDays(int[] bloomDay, int m, int k) {
        int targetFlowerNumer = m * k;
        if (bloomDay.length < targetFlowerNumer) {
            return -1;
        }
        // 等待天数的边界，l应该是 bloomDay数组中的最小值，r应该是bloomDay数组中最大值
        int l = bloomDay[0], r = bloomDay[0];
        for (int day : bloomDay) {
            l = Math.min(l, day);
            r = Math.max(r, day);
        }
        int min = l;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int midFlowerNumber = flowerNumberByDays(bloomDay, mid, k);
            if (midFlowerNumber == m) {
                if (mid == min || flowerNumberByDays(bloomDay, mid - 1, k) < m) {
                    return mid;
                }
                // mid天数此时在非解区间内，r应该在非解区间，r应该向左收缩
                r = mid - 1;
            } else if (midFlowerNumber > m) {
                // mid天数此时在非解区间内，r应该在非解区间，r应该向左收缩
                r = mid - 1;
            } else {
                // midFlowerNumber < targetFlowerNumer
                // 此时mid天数在非解区间，l也在非解区间，l应该向右收缩
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * days 天数能等出成熟的 n朵花
     * 单调非严格递增
     * - 等越久，成熟的花朵越多
     * - 等同样天数，成熟的花朵数可能相同
     *
     * @param k k朵一束，需连续花朵
     */
    public int flowerNumberByDays(int[] bloomDay, int days, int k) {
        int ans = 0;

        // 连续在days天数内能等到的花朵数量
        int curr = 0;
        for (int day : bloomDay) {
            if (days >= day) {
                curr += 1;
            } else {
                ans = ans + curr / k;
                curr = 0;
            }
        }
        return ans + curr / k;
    }
}
