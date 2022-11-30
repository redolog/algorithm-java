package com.algorithm.lookup;

/**
 * https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 *
 * @author songhuilong001  @date 2022/12/1
 */
public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1, minDistance = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int xi = point[0], yi = point[1];
            if (xi == x || yi == y) {
                int manhattanDistance = manhattanDistance(x, y, xi, yi);
                if (minDistance == -1) {
                    minDistance = manhattanDistance;
                    ans = i;
                } else if (manhattanDistance < minDistance) {
                    ans = i;
                    minDistance = manhattanDistance;
                }
            }
        }

        return ans;
    }

    private int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
