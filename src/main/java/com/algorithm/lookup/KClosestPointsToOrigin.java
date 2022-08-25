package com.algorithm.lookup;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/k-closest-points-to-origin/
 *
 * @author dragonsong  @date 2022/8/19
 */
public class KClosestPointsToOrigin {

    /**
     * 时间复杂度：排序 n*logn
     * 空间复杂度：排序递归栈：logn
     */
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (int) (Math.pow(a[0], 2) + Math.pow(a[1], 2) - (b[0] * b[0] + b[1] * b[1])));

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = points[i];
        }
        return ans;
    }

    static class Heap {
        /**
         * 使用最大堆维护前k个较小值，堆顶维护的就是前k小中最大值（作为边界）
         * <p>
         * 时间复杂度：建堆 O(k) 后期逐个对比、入堆 O(logk)
         * 空间复杂度：维护一个额外的最大堆 O(k)
         */
        public int[][] kClosest(int[][] points, int k) {
            Queue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(this::distance).reversed());
            for (int i = 0; i < points.length; i++) {
                int[] currPoint = points[i];
                if (i < k) {
                    maxHeap.offer(currPoint);
                } else {
                    if (distance(currPoint) < distance(maxHeap.peek())) {
                        maxHeap.poll();
                        maxHeap.offer(currPoint);
                    }
                }
            }
            int[][] ans = new int[k][2];
            for (int i = 0; i < k; i++) {
                ans[i] = maxHeap.poll();
            }
            return ans;
        }

        private int distance(int[] point) {
            return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
        }
    }
}
