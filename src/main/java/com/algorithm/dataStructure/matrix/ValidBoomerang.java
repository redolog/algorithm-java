package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/valid-boomerang/
 *
 * @author songhuilong  @date 2022/12/6
 */
public class ValidBoomerang {

    public boolean isBoomerang(int[][] points) {
        return notEquals(points[0], points[1]) && notEquals(points[2], points[1]) && notEquals(points[2], points[0]) && notInOneLine(points);
    }

    private boolean notInOneLine(int[][] points) {
        return !inOneLine(points);
    }

    private boolean inOneLine(int[][] points) {
        // a/b/c 三点
        // 以a为起点，b与a的斜率 == c与a的斜率
        // (y1-y0) / (x1-x0) == (y2-y0) / (x2-x0)
        // (y1-y0) * (x2-x0) == (y2-y0) * (x1-x0)
        return ((points[1][1] - points[0][1]) * (points[2][0] - points[0][0])) == ((points[2][1] - points[0][1]) * (points[1][0] - points[0][0]));
    }

    private boolean equals(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private boolean notEquals(int[] p1, int[] p2) {
        return !equals(p1, p2);
    }
}
