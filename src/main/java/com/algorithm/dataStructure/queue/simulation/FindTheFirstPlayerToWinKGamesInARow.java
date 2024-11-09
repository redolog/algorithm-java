package com.algorithm.dataStructure.queue.simulation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 有 n 位玩家在进行比赛，玩家编号依次为 0 到 n - 1 。
 * <p>
 * 给你一个长度为 n 的整数数组 skills 和一个 正 整数 k ，其中 skills[i] 是第 i 位玩家的技能等级。skills 中所有整数 互不相同 。
 * <p>
 * 所有玩家从编号 0 到 n - 1 排成一列。
 * <p>
 * 比赛进行方式如下：
 * <p>
 * 队列中最前面两名玩家进行一场比赛，技能等级 更高 的玩家胜出。
 * 比赛后，获胜者保持在队列的开头，而失败者排到队列的末尾。
 * 这个比赛的赢家是 第一位连续 赢下 k 场比赛的玩家。
 * <p>
 * 请你返回这个比赛的赢家编号。
 *
 * <a href="https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row/description/">3175. 找到连续赢 K 场比赛的第一位玩家</a>
 *
 * @author songhuilong  @date 2024/10/25
 */
public class FindTheFirstPlayerToWinKGamesInARow {

    /**
     * 时间复杂度：需要比拼n轮，O(n)
     * 空间复杂度：使用了额外的两个容器，一个双端队列，一个map，均需n的空间，O(n)
     */
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int maxIdx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        // 先将所有元素入队
        for (int i = 0; i < n; i++) {
            deque.offerLast(i);
            if (skills[i] > skills[maxIdx]) {
                maxIdx = i;
            }
        }
        // 记录每个元素连续赢的次数
        Map<Integer, Integer> idx2WinContinuousCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 对比n轮
            // 每轮对比中，将较大值留在队头，将较小值放到队尾
            Integer firstIdx = deque.pollFirst();
            Integer secondIdx = deque.pollFirst();
            int winIdx = firstIdx;
            int loseIdx = secondIdx;
            if (skills[firstIdx] < skills[secondIdx]) {
                winIdx = secondIdx;
                loseIdx = firstIdx;
            }
            deque.offerFirst(winIdx);
            deque.offerLast(loseIdx);
            int winContinuousCnt = idx2WinContinuousCnt.getOrDefault(winIdx, 0) + 1;
            idx2WinContinuousCnt.put(winIdx, winContinuousCnt);
            if (winContinuousCnt == k) {
                return winIdx;
            }
        }
        // 对比了n轮都没找出连续赢k轮的人，则返回所有元素中的最大值
        return maxIdx;
    }

    /**
     * 遍历入参数组，逐个对比，维护当前的更大值以及对应的胜次数
     * 维护一个遍历过程中的最大值，如果数组遍历完仍没有获胜次数达到k次的，则答案为数组中的最大值（此时比它小的值都排到了队列最后，依次对比，最大值胜次一定会达到k次）
     * <p>
     * 时间复杂度：O(n)，需完整遍历一次入参数组
     * 空间复杂度：O(1)，仅使用常量个变量维护状态
     */
    public int findWinningPlayer2(int[] skills, int k) {
        // 当前对比下来更大值下标
        int currBiggerIdx = 0;
        // 当前胜次
        int biggerWinCnt = 0;
        // 序列中最大值的下标
        int maxIdx = 0;

        int n = skills.length;
        for (int i = 1; i < n; i++) {
            int curr = skills[i];
            int prev = skills[currBiggerIdx];
            if (curr > prev) {
                // 当前值大于前序的更大值，更新更大值
                maxIdx = i;
                biggerWinCnt = 1;
                currBiggerIdx = i;
            } else {
                // 前序的更大值依然是更大值，累加其胜次
                biggerWinCnt++;
            }
            if (biggerWinCnt == k) {
                return currBiggerIdx;
            }
        }
        // 遍历了完整数组都没找到对应的连续赢k次的元素，此时返回最大值下标
        return maxIdx;
    }
}
