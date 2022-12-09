package com.algorithm.lookup.bsearch;

/**
 * https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * @author songhuilong001  @date 2022/12/9
 */
public class CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {
        int ans = 0, n = grid[0].length, l, r;
        for (int[] row : grid) {
            // 二分，找当前行最大的负数
            l = 0;
            r = n - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (row[mid] < 0) {
                    if (mid == 0 || row[mid - 1] >= 0) {
                        ans += n - mid;
                        break;
                    }
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return ans;
    }
}
