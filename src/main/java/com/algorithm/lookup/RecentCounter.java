package com.algorithm.lookup;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/H8086Q/
 *
 * @author songhuilong  @date 2022/9/13
 */
public class RecentCounter {

    static class TreeMapSolution {
        /**
         * 时间复杂度：O(3000)
         */
        SortedMap<Integer, Integer> time2Cnt;

        public TreeMapSolution() {
            time2Cnt = new TreeMap<>();
        }

        public int ping(int t) {
            time2Cnt.put(t, time2Cnt.getOrDefault(t, 0) + 1);
            return time2Cnt.subMap(t - 3000, t + 1).values().stream().reduce(Integer::sum).orElse(0);
        }
    }

    static class QueueSolution {
        /**
         * 时间复杂度：O(1)
         */
        Queue<Integer> timeQ;

        public QueueSolution() {
            timeQ = new ArrayDeque<>();
        }

        public int ping(int t) {
            timeQ.offer(t);
            while (!timeQ.isEmpty() && timeQ.peek() < t - 3000) {
                timeQ.poll();
            }
            return timeQ.size();
        }
    }


}
