package com.algorithm.dataStructure.array.app;

/**
 * https://leetcode.cn/problems/diving-board-lcci/
 *
 * @author songhuilong001  @date 2022/11/20
 */
public class DivingBoardLcci {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }
        // 短板越多，总长越短，一共k+1种情况
        int n = k + 1, i = 0;
        int[] ans = new int[n];
        for (int s = k; s >= 0; s--) {
            ans[i++] = shorter * s + longer * (k - s);
        }
        return ans;
    }
}
