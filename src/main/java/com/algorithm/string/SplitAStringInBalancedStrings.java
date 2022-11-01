package com.algorithm.string;

/**
 * https://leetcode.cn/problems/split-a-string-in-balanced-strings/
 *
 * @author songhuilong  @date 2022/11/1
 */
public class SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        // 记录当前平衡子串单一字符计数
        int currCnt = 0, prevIdx = 0, n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || s.charAt(prevIdx) == s.charAt(i)) {
                currCnt++;
            } else {
                currCnt--;
                if (currCnt == 0) {
                    ans++;
                    prevIdx = i + 1;
                }
            }
        }
        return ans;
    }

    public int balancedStringSplit2(String s) {
        int currCnt = 0, ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                currCnt++;
            } else {
                currCnt--;
            }
            if (currCnt == 0) {
                ans++;
            }
        }
        return ans;
    }
}
