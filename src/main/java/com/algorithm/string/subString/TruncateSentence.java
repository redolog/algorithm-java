package com.algorithm.string.subString;

/**
 * https://leetcode.cn/problems/truncate-sentence/
 *
 * @author songhuilong  @date 2022/12/30
 */
public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        int n = s.length(), breakI = n;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                k--;
            }
            if (k == 0) {
                breakI = i;
                break;
            }
        }
        return s.substring(0, breakI);
    }
}
