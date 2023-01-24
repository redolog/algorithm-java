package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/queries-on-number-of-points-inside-a-circle/
 *
 * @author songhuilong001  @date 2023/1/24
 */
public class QueriesOnNumberOfPointsInsideCircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int cnt = 0;
            for (int[] point : points) {
                if (inside(point, query)) {
                    cnt++;
                }
            }
            ans[i++] = cnt;
        }
        return ans;
    }

    private boolean inside(int[] point, int[] query) {
        int x = query[0], y = query[1], r = query[2], px = point[0], py = point[1];
        return Math.pow(px - x, 2) + Math.pow(py - y, 2) <= Math.pow(r, 2);
    }
}
