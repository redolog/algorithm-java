package com.algorithm.string;

/**
 * https://leetcode.cn/problems/minimum-moves-to-convert-string/
 *
 * @author songhuilong  @date 2022/12/27
 */
public class MinimumMovesToConvertString {

    public int minimumMoves(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i += 3) {
            while (i < n && s.charAt(i) == 'O') {
                i++;
            }
            if (i >= n) {
                break;
            }
            ans++;
        }
        return ans;
    }
}
