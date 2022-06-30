package com.algorithm.dataStructure.matrix;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * https://leetcode.cn/problems/rotting-oranges/
 *
 * @author dragonsong  @date 2022/6/30
 */
public class RottingOranges {

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 40.9 MB
     * , 在所有 Java 提交中击败了
     * 50.19%
     * 的用户
     * 通过测试用例：
     * 306 / 306
     */

    /**
     * 思路：
     * 从腐烂的橘子开始，多源BFS扩散，一直扩散到空位或者边界即可
     * 使用一个变量来维护最大距离
     */
    public int orangesRotting(int[][] grid) {
        // 666表示已经访问过了
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> pointQ = new ArrayDeque<>();
        int freshCnt = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 2) {
                    pointQ.offer(new int[]{row, col});
                    grid[row][col] = 666;
                }

                if (grid[row][col] == 1) {
                    freshCnt++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pointQ.isEmpty() && freshCnt > 0) {
            int size = pointQ.size();

            for (int i = 0; i < size; i++) {
                int[] point = pointQ.poll();
                int x = point[0];
                int y = point[1];

                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (!inArea(newX, m) || !inArea(newY, n) || grid[newX][newY] == 666 || grid[newX][newY] == 0) {
                        continue;
                    }
                    // 新鲜橘子变腐烂，同时标记访问状态
                    grid[newX][newY] = 666;
                    pointQ.offer(new int[]{newX, newY});
                    // 某一轮过来的时候可能已经没有新鲜橘子了，此时判断下状态再计数
                    freshCnt--;
                }
            }
            minutes++;
        }
        return freshCnt > 0 ? -1 : minutes;
    }

    private boolean inArea(int x, int m) {
        return x >= 0 && x < m;
    }

    /**
     * java中contains数组，或者说数组类型的equals，由于放在set中，判断 a.equals(b) 时，由于泛型擦除，不会调用 Arrays.arraysEquals
     * 而普通对象这里的 equals 返回为 false，因此使用set此题解不过。
     */
    public int orangesRottingWithSet(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 新鲜橘子
        Set<int[]> freshSet = new HashSet<>();
        // 腐烂橘子
        Set<int[]> rottedSet = new HashSet<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    freshSet.add(new int[]{row, col});
                }
                if (grid[row][col] == 2) {
                    rottedSet.add(new int[]{row, col});
                }
            }
        }
        // 没有新鲜橘子，没有必要计算了
        if (freshSet.size() == 0) {
            return 0;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minutes = 0;
        while (freshSet.size() > 0) {
            Set<int[]> roundRotted = new HashSet<>();
            for (int[] freshPoint : freshSet) {
                int x = freshPoint[0];
                int y = freshPoint[1];
                // 新鲜橘子四周只要有腐烂的橘子，就加入腐烂橘子集合
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    int[] newPoint = {newX, newY};
                    if (rottedSet.contains(newPoint)) {
                        roundRotted.add(newPoint);
                    }
                }
            }
            if (roundRotted.size() == 0) {
                return -1;
            }
            // 新鲜橘子移除本轮腐烂的
            freshSet.removeAll(roundRotted);
            // 腐烂橘子集合新增一批
            rottedSet.addAll(roundRotted);
            minutes++;
        }
        return minutes;
    }

}
