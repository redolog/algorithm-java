package com.algorithm.math;

/**
 * https://leetcode.cn/problems/circle-and-rectangle-overlapping/
 *
 * @author songhuilong  @date 2022/10/9
 */
public class CircleAndRectangleOverlapping {

    /**
     * 圆中心与当前可能相交的边的最短距离，与radius半径比较即可
     */
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        boolean xInRecRange = xCenter >= x1 && xCenter <= x2;
        boolean yInRecRange = yCenter >= y1 && yCenter <= y2;
        if (xInRecRange && yInRecRange) {
            // 圆在矩形内
            return true;
        }
        if (xInRecRange) {
            // 中心点在矩形x轴边范围内
            return Math.min(Math.abs(yCenter - y1), Math.abs(yCenter - y2)) <= radius;
        }
        if (yInRecRange) {
            // 中心点在矩形y轴边范围内
            return Math.min(Math.abs(xCenter - x1), Math.abs(xCenter - x2)) <= radius;
        }
        // x、y轴范围不重合，看圆形中点距离最近的点有无在圆内
        return getDistance(xCenter, yCenter, x1, y1) <= radius || getDistance(xCenter, yCenter, x1, y2) <= radius || getDistance(xCenter, yCenter, x2, y1) <= radius || getDistance(xCenter, yCenter, x2, y2) <= radius;
    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }
}
