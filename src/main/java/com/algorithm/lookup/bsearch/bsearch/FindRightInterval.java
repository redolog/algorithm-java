package com.algorithm.lookup.bsearch.bsearch;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-right-interval/
 *
 * @author dragonsong  @date 2022/8/17
 */
public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[][] startIdxArr = new int[n][2];
        for (int row = 0; row < n; row++) {
            // 第一位存区间start值
            startIdxArr[row][0] = intervals[row][0];
            // 第二位存原位置
            startIdxArr[row][1] = row;
        }
        Arrays.sort(startIdxArr, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            // 查找比 currEnd 更大的 start，目前我们的start数组已经增序了
            int currEnd = intervals[i][1];
            // 找到的下标
            int currIdx = -1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                int midStart = startIdxArr[mid][0];
                if (midStart >= currEnd) {
                    if (mid == 0 || startIdxArr[mid - 1][0] < currEnd) {
                        currIdx = mid;
                        break;
                    }
                    // mid位置大于等于end，并且前一个位置mid-1的值依然是大于等于，区间整体左移
                    r = mid - 1;
                } else {
                    // startIdxArr[mid]<=currEnd
                    l = mid + 1;
                }
            }
            ans[i] = currIdx == -1 ? -1 : startIdxArr[currIdx][1];
        }

        return ans;
    }
}
