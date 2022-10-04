package com.algorithm.greedy;

/**
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/submissions/
 *
 * @author DragonSong  @date 2022/10/4
 */
public class MinimumAddToMakeParenthesesValid {

    /**
     * n==s.length()
     * 时间复杂度：O(n)
     * 空间复杂度，遍历字符串不创建charArray，使用charAt访问对应字符：O(1)
     */
    public int minAddToMakeValid(String s) {
        int lCnt = 0, rCnt = 0, n = s.length();
        // 左右交替出现，则消除掉lCnt，如果左括号没有，则对rCnt计数
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lCnt++;
            } else {
                if (lCnt > 0) {
                    lCnt--;
                } else {
                    rCnt++;
                }
            }
        }
        return lCnt + rCnt;
    }
}
