package com.algorithm.lookup.bsearch;

import java.util.Arrays;

/**
 * 1552. 两球之间的磁力
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * <p>
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * <p>
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：position = [1,2,3,4,7], m = 3
 * 输出：3
 * 解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 * 示例 2：
 * <p>
 * 输入：position = [5,4,3,2,1,1000000000], m = 2
 * 输出：999999999
 * 解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有 position 中的整数 互不相同 。
 * 2 <= m <= position.length
 * <p>
 * https://leetcode.cn/problems/magnetic-force-between-two-balls/
 *
 * @author dragonsong  @date 2022/7/27
 */
public class MagneticForceBetweenTwoBalls {

    /*
     * 执行用时：
     * 52 ms
     * , 在所有 Java 提交中击败了
     * 18.05%
     * 的用户
     * 内存消耗：
     * 55.7 MB
     * , 在所有 Java 提交中击败了
     * 70.00%
     * 的用户
     * 通过测试用例：
     * 98 / 98
     */

    public int maxDistance(int[] position, int m) {
        // n*logn
        Arrays.sort(position);
        int n = position.length;
        // 设我们的磁力（距离）边界为l r
        int l = position[0], r = position[n - 1];

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int cnt = cntBallsByDistance(mid - position[0], position);
            if (cnt >= m) {
                // 边界
                if (mid == position[n - 1] || cntBallsByDistance(mid + 1 - position[0], position) < m) {
                    return mid - position[0];
                }
                // 此时mid对应cnt已经满足了条件，尝试往更右的方向移动
                l = mid + 1;
            } else {
                // cnt < m
                // 放不下m个球，说明距离太大了
                r = mid - 1;
            }
        }
        return l - position[0];
    }

    // min-l 表示距离，距离越小，固定篮子内能放的球越多
    public int cntBallsByDistance(int distance, int[] position) {
        int cnt = 1;
        int prev = position[0];
        for (int i = 1; i < position.length; i++) {
            // 达到我们的distance之后才放置
            if (position[i] - prev >= distance) {
                cnt++;
                prev = position[i];
            }
        }
        return cnt;
    }
}
