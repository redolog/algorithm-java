package com.algorithm.dataStructure.matrix;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/">...</a>
 *
 * @author songhuilong  @date 2023/3/30
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public int maxWidthOfVerticalArea(int[][] points) {
        // x坐标排序
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        int maxWidth = 0;
        for (int i = 1; i < points.length; i++) {
            maxWidth = Math.max(maxWidth, points[i][0] - points[i - 1][0]);
        }
        return maxWidth;
    }
}
