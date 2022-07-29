package com.algorithm.dataStructure.queue.simulation;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2073. 买票需要的时间
 * 有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
 * <p>
 * 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
 * <p>
 * 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。
 * <p>
 * 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tickets = [2,3,2], k = 2
 * 输出：6
 * 解释：
 * - 第一轮，队伍中的每个人都买到一张票，队伍变为 [1, 2, 1] 。
 * - 第二轮，队伍中的每个都又都买到一张票，队伍变为 [0, 1, 0] 。
 * 位置 2 的人成功买到 2 张票，用掉 3 + 3 = 6 秒。
 * 示例 2：
 * <p>
 * 输入：tickets = [5,1,1,1], k = 0
 * 输出：8
 * 解释：
 * - 第一轮，队伍中的每个人都买到一张票，队伍变为 [4, 0, 0, 0] 。
 * - 接下来的 4 轮，只有位置 0 的人在买票。
 * 位置 0 的人成功买到 5 张票，用掉 4 + 1 + 1 + 1 + 1 = 8 秒。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == tickets.length
 * 1 <= n <= 100
 * 1 <= tickets[i] <= 100
 * 0 <= k < n
 * <p>
 * https://leetcode.cn/problems/time-needed-to-buy-tickets/
 *
 * @author dragonsong  @date 2022/7/29
 */
public class TimeNeededToBuyTickets {
    /*
     * 执行用时：
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 9.60%
     * 的用户
     * 内存消耗：
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 53.60%
     * 的用户
     * 通过测试用例：
     * 65 / 65
     */

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++) {
            int[] people = new int[2];
            people[0] = tickets[i];
            if (i == k) {
                // 表示我们需要记录的k元素
                people[1] = 666;
            }
            queue.offer(people);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            ans++;
            if (curr[0] > 1) {
                curr[0] -= 1;
                queue.offer(curr);
            } else if (curr[0] == 1 && curr[1] == 666) {
                break;
            }
        }
        return ans;
    }

    static class MathSolution {

        /**
         * 分析：
         * 1. k以及k之前的人，在k买完票前，每个人最多能买 min(tickets[i],tickets[k])
         * - tickets[i]更小（包含等于）时，这个人就已经买完了，不排队了
         * - tickets[i]更大时，这个人等k买完后会继续排队，我们不关心之后发生了什么
         * 2. k之后的人，在k买完票前，每个人最多能买 min(tickets[i],tickets[k]-1)
         * - k买完一张之后，排到后面，情况等同于1.，所以与 tickets[k]-1 比较出一个较小值
         */
        public int timeRequiredToBuy(int[] tickets, int k) {
            int ans = 0;
            for (int i = 0; i < tickets.length; i++) {
                if (i <= k) {
                    ans += Math.min(tickets[i], tickets[k]);
                } else {
                    ans += Math.min(tickets[i], tickets[k] - 1);
                }
            }
            return ans;
        }

    }
}
