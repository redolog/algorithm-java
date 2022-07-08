package com.algorithm.app;

import java.util.*;

/**
 * https://leetcode.cn/problems/design-a-leaderboard/
 *
 * @author dragonsong  @date 2022/7/8
 */
public class LeetcodeLeaderboard {

    /*
     * 执行用时：
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 69.03%
     * 的用户
     * 内存消耗：
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 75.22%
     * 的用户
     * 通过测试用例：
     * 18 / 18
     */
    static class Leaderboard {
        /**
         * 分数排序
         */
        SortedMap<Integer, SortedSet<Integer>> score2PlayerIdSet;
        /**
         * 选手-》分数
         */
        Map<Integer, Integer> playerId2Score;

        public Leaderboard() {
            score2PlayerIdSet = new TreeMap<>(Comparator.reverseOrder());
            playerId2Score = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            if (playerId2Score.containsKey(playerId)) {
                // 原先存在该玩家数据
                Integer oldScore = playerId2Score.get(playerId);
                SortedSet<Integer> playerIdSet = score2PlayerIdSet.get(oldScore);
                playerIdSet.remove(playerId);

                // 增加新的分数
                score += oldScore;
            }

            playerId2Score.put(playerId, score);
            SortedSet<Integer> playerIdSet = score2PlayerIdSet.getOrDefault(score, new TreeSet<>(Comparator.naturalOrder()));
            playerIdSet.add(playerId);
            score2PlayerIdSet.put(score, playerIdSet);
        }

        public int top(int k) {
            int sum = 0;
            int i = 0;
            for (Map.Entry<Integer, SortedSet<Integer>> entry : score2PlayerIdSet.entrySet()) {
                Integer score = entry.getKey();
                SortedSet<Integer> playerIds = entry.getValue();
                for (Integer ignored : playerIds) {
                    if (i == k) {
                        return sum;
                    }
                    sum += score;
                    ++i;
                }
            }
            return sum;
        }

        public void reset(int playerId) {
            if (playerId2Score.containsKey(playerId)) {
                // 原来存在该玩家分数
                Integer oldScore = playerId2Score.get(playerId);
                SortedSet<Integer> playerIds = score2PlayerIdSet.get(oldScore);
                playerIds.remove(playerId);
            }
            playerId2Score.remove(playerId);
        }
    }

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
}
