package com.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2335. 装满杯子需要的最短总时长
 * 现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。
 * <p>
 * 给你一个下标从 0 开始、长度为 3 的整数数组 amount ，其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 最少 秒数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：amount = [1,4,2]
 * 输出：4
 * 解释：下面给出一种方案：
 * 第 1 秒：装满一杯冷水和一杯温水。
 * 第 2 秒：装满一杯温水和一杯热水。
 * 第 3 秒：装满一杯温水和一杯热水。
 * 第 4 秒：装满一杯温水。
 * 可以证明最少需要 4 秒才能装满所有杯子。
 * 示例 2：
 * <p>
 * 输入：amount = [5,4,4]
 * 输出：7
 * 解释：下面给出一种方案：
 * 第 1 秒：装满一杯冷水和一杯热水。
 * 第 2 秒：装满一杯冷水和一杯温水。
 * 第 3 秒：装满一杯冷水和一杯温水。
 * 第 4 秒：装满一杯温水和一杯热水。
 * 第 5 秒：装满一杯冷水和一杯热水。
 * 第 6 秒：装满一杯冷水和一杯温水。
 * 第 7 秒：装满一杯热水。
 * 示例 3：
 * <p>
 * 输入：amount = [5,0,0]
 * 输出：5
 * 解释：每秒装满一杯冷水。
 * <p>
 * <p>
 * 提示：
 * <p>
 * amount.length == 3
 * 0 <= amount[i] <= 100
 * <p>
 * https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 *
 * @author dragonsong  @date 2022/7/25
 */
public class MinimumAmountOfTimeToFillCups {

    /**
     * 最大值>=其余两项和时，总用时==最大值
     * 否则，最大值轮流与剩余两类水一起接：
     * - 总数为偶时，轮流刚好接完，即 ans=sum/2
     * - 总数为奇时，轮流接完，最大值再接1，ans=sum/2+1
     * <p>
     * 时间空间复杂度均为 O(1)
     */
    public int fillCups(int[] amount) {
        int max = Math.max(amount[0], Math.max(amount[1], amount[2]));
        int sum = amount[0] + amount[1] + amount[2];
        if (max * 2 >= sum) {
            return max;
        }
        if ((sum & 1) == 0) {
            return sum / 2;
        }
        return sum / 2 + 1;
    }

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.6 MB
     * , 在所有 Java 提交中击败了
     * 99.91%
     * 的用户
     * 通过测试用例：
     * 280 / 280
     */

    static class Simulation {

        /*
         * 执行用时：
         * 2 ms
         * , 在所有 Java 提交中击败了
         * 21.07%
         * 的用户
         * 内存消耗：
         * 39.3 MB
         * , 在所有 Java 提交中击败了
         * 47.80%
         * 的用户
         * 通过测试用例：
         * 280 / 280
         */

        /*
         * Runtime: 4 ms, faster than 36.21% of Java online submissions for Minimum Amount of Time to Fill Cups.
         * Memory Usage: 42.9 MB, less than 5.22% of Java online submissions for Minimum Amount of Time to Fill Cups.
         */

        /**
         * 观察用例，发现，正确的模拟方式是：
         * 用最多的amount与其余两个轮流一起接，最后将剩下的一个按秒解完
         * 模拟需要一个有序的集合，我们用heap结构尝试
         * <p>
         * 时间复杂度取决于amount数字大小 O(n)
         * 空间复杂度 O(3)
         */
        public int fillCups(int[] amount) {
            int ans = 0;
            Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int a : amount) {
                if (a > 0) {
                    queue.offer(a);
                }
            }
            while (!queue.isEmpty()) {
                if (queue.size() == 1) {
                    ans += queue.poll();
                    return ans;
                }
                // 取出第一第二一起消费
                Integer first = queue.poll();
                Integer second = queue.poll();
                ans += 1;
                if (first - 1 > 0) {
                    queue.offer(first - 1);
                }
                if (second - 1 > 0) {
                    queue.offer(second - 1);
                }
            }
            return ans;
        }
    }
}
