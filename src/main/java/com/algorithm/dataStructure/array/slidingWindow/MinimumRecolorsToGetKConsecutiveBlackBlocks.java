package com.algorithm.dataStructure.array.slidingWindow;

/**
 * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 *
 * @author dragonsong  @date 2022/8/21
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    /**
     * 滑动窗口：维护一个k长度的窗口，挪动窗口，统计每个窗口中包含的最少白块数
     */
    public int minimumRecolors(String blocks, int k) {
        int l = 0, r = 0, whiteCnt = 0;
        // 窗口初始状态
        while (r < k) {
            if (blocks.charAt(r) == 'W') {
                whiteCnt++;
            }
            r++;
        }

        int ans = whiteCnt;
        while (r < blocks.length()) {
            // 上个窗口左边界为白色，当次窗口减去上个窗口的一个白色计数
            if (blocks.charAt(l) == 'W') {
                whiteCnt--;
            }
            l++;
            if (blocks.charAt(r) == 'W') {
                whiteCnt++;
            }
            r++;
            ans = Math.min(ans, whiteCnt);
        }
        return ans;
    }
}
