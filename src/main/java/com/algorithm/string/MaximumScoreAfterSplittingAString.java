package com.algorithm.string;

/**
 * 1422. Maximum Score After Splitting a String
 * Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).
 * <p>
 * The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "011101"
 * Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3
 * Example 2:
 * <p>
 * Input: s = "00111"
 * Output: 5
 * Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
 * Example 3:
 * <p>
 * Input: s = "1111"
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= s.length <= 500
 * The string s consists of characters '0' and '1' only.
 * <p>
 * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
 *
 * @author dragonsong  @date 2022/8/14
 */
public class MaximumScoreAfterSplittingAString {

    public int maxScore(String s) {
        int oneCnt = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                oneCnt++;
            }
        }

        int ans = 0;
        int oneCntCurr = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                oneCntCurr++;
            }
            ans = Math.max(ans, (i + 1 - oneCntCurr) + (oneCnt - oneCntCurr));
        }
        return ans;
    }
}
