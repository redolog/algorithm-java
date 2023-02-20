package com.algorithm.dataStructure.array.app.poker;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/best-poker-hand/
 *
 * @author songhuilong  @date 2023/2/20
 */
public class BestPokerHand {

    static class StreamSolution {
        public String bestHand(int[] ranks, char[] suits) {
            Set<Character> suitSet = new HashSet<>();
            for (char suit : suits) {
                suitSet.add(suit);
            }
            if (suitSet.size() == 1) {
                return "Flush";
            }
            // 大小-》计数
            Map<Integer, Integer> rank2Cnt = Arrays.stream(ranks).boxed().collect(Collectors.toMap(rank -> rank, k -> 1, Integer::sum));

            if (rank2Cnt.keySet().stream().anyMatch(rank -> rank2Cnt.get(rank) >= 3)) {
                return "Three of a Kind";
            }
            if (rank2Cnt.keySet().stream().anyMatch(rank -> rank2Cnt.get(rank) == 2)) {
                return "Pair";
            }
            return "High Card";
        }
    }

    static class CntSolution {
        public String bestHand(int[] ranks, char[] suits) {
            Set<Character> suitSet = new HashSet<>();
            for (char suit : suits) {
                suitSet.add(suit);
            }
            if (suitSet.size() == 1) {
                return "Flush";
            }
            Map<Integer, Integer> rank2Cnt = new HashMap<>();
            for (int rank : ranks) {
                rank2Cnt.merge(rank, 1, Integer::sum);
            }
            if (rank2Cnt.size() == 5) {
                return "High Card";
            }
            for (Integer cnt : rank2Cnt.values()) {
                if (cnt >= 3) {
                    return "Three of a Kind";
                }
            }
            return "Pair";
        }
    }

}
