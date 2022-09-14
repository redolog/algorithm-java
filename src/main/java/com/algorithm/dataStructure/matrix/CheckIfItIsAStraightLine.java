package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/check-if-it-is-a-straight-line/
 *
 * @author songhuilong  @date 2022/9/14
 */
public class CheckIfItIsAStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        // 找到最左侧的点，作为计算斜率的起点
        int startI = 0;
        for (int i = 0; i < coordinates.length; i++) {
            int[] coordinate = coordinates[i];
            int currX = coordinate[0];
            if (currX < coordinates[startI][0]) {
                startI = i;
            }
        }
        if (startI != 0) {
            swap(coordinates, 0, startI);
        }
        for (int i = 2; i < coordinates.length; i++) {
            // p0 p1 pi
            // (y0-y1)/(x0-x1) == (y0-yi)/(x0-xi)
            // (y0-y1)*(x0-xi) == (y0-yi)*(x0-x1)
            int[] p0 = coordinates[0];
            int[] p1 = coordinates[1];
            int[] pi = coordinates[i];
            int x0 = p0[0];
            int y0 = p0[1];
            int x1 = p1[0];
            int y1 = p1[1];
            int xi = pi[0];
            int yi = pi[1];
            if ((y0 - y1) * (x0 - xi) != (y0 - yi) * (x0 - x1)) {
                return false;
            }
        }
        return true;
    }

    // 两点交换
    private void swap(int[][] coordinates, int a, int b) {
        int[] tmp = coordinates[a];
        coordinates[a] = coordinates[b];
        coordinates[b] = tmp;
    }
}
