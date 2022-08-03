package com.algorithm.company.codility;

import java.util.*;

/**
 * There are N points (numbered from 0 to N−1) on a plane. Each point is colored either red ('R') or green ('G'). The K-th point is located at coordinates (X[K], Y[K]) and its color is colors[K]. No point lies on coordinates (0, 0).
 * <p>
 * We want to draw a circle centered on coordinates (0, 0), such that the number of red points and green points inside the circle is equal. What is the maximum number of points that can lie inside such a circle? Note that it is always possible to draw a circle with no points inside.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] X, int[] Y, String colors); }
 * <p>
 * that, given two arrays of integers X, Y and a string colors, returns an integer specifying the maximum number of points inside a circle containing an equal number of red points and green points.
 * <p>
 * Examples:
 * <p>
 * 1. Given X = [4, 0, 2, −2], Y = [4, 1, 2, −3] and colors = "RGRR", your function should return 2. The circle contains points (0, 1) and (2, 2), but not points (−2, −3) and (4, 4).
 * <p>
 * The image illustrates the first example test.
 * <p>
 * 2. Given X = [1, 1, −1, −1], Y = [1, −1, 1, −1] and colors = "RGRG", your function should return 4. All points lie inside the circle.
 * <p>
 * The image illustrates the second example test.
 * <p>
 * 3. Given X = [1, 0, 0], Y = [0, 1, −1] and colors = "GGR", your function should return 0. Any circle that contains more than zero points has an unequal number of green and red points.
 * <p>
 * The image illustrates the third example test.
 * <p>
 * 4. Given X = [5, −5, 5], Y = [1, −1, −3] and colors = "GRG", your function should return 2.
 * <p>
 * The image illustrates the fourth example test.
 * <p>
 * 5. Given X = [3000, −3000, 4100, −4100, −3000], Y = [5000, −5000, 4100, −4100, 5000] and colors = "RRGRG", your function should return 2.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of arrays X and Y is an integer within the range [−20,000..20,000];
 * string colors consists only of the characters "R" and/or "G";
 * no point lies on the coordinates (0, 0).
 *
 * @author dragonsong  @date 2022/8/3
 */
public class MaximumNumberOfPointsIncludingEqualNumberOfRG {

    /**
     * 空间复杂度 O(n)
     * 时间复杂度 O(n*logn)
     */
    public int maximumNumberOfPointsIncludingEqualNumberOfRG(int[] x, int[] y, String colors) {
        // 降序维护距离
        Queue<Long> distanceQ = new PriorityQueue<>(Comparator.reverseOrder());
        // 距离对应红色数量
        Map<Long, Integer> distance2RCnt = new HashMap<>();
        // 距离对应绿色数量
        Map<Long, Integer> distance2GCnt = new HashMap<>();
        int n = x.length;
        int rCnt = 0, gCnt = 0;
        for (int i = 0; i < n; i++) {
            int xi = x[i];
            int yi = y[i];
            long distance = (long) (Math.pow(xi, 2) + Math.pow(yi, 2));
            if (!distance2RCnt.containsKey(distance) && !distance2GCnt.containsKey(distance)) {
                distanceQ.offer(distance);
            }
            char color = colors.charAt(i);
            if (color == 'R') {
                rCnt++;
                distance2RCnt.put(distance, distance2RCnt.getOrDefault(distance, 0) + 1);
            } else {
                gCnt++;
                distance2GCnt.put(distance, distance2GCnt.getOrDefault(distance, 0) + 1);
            }
        }

        int ans = n;
        while (!distanceQ.isEmpty()) {
            if (rCnt == gCnt) {
                break;
            }
            long distance = distanceQ.poll();
            Integer rDecre = distance2RCnt.getOrDefault(distance, 0);
            rCnt -= rDecre;
            ans -= rDecre;
            Integer gDecre = distance2GCnt.getOrDefault(distance, 0);
            gCnt -= gDecre;
            ans -= gDecre;
        }
        return ans;
    }
}
