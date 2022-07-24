package com.algorithm.greedy;

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

    /**
     * 最大值>=其余两项和时，总用时==最大值
     * 否则，最大值轮流与剩余两类水一起接：
     * - 总数为偶时，轮流刚好接完，即 ans=sum/2
     * - 总数为奇时，轮流接完，最大值再接1，ans=sum/2+1
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
}
