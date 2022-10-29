package com.algorithm.string;

/**
 * https://leetcode.cn/problems/longer-contiguous-segments-of-ones-than-zeros/
 *
 * @author DragonSong  @date 2022/10/29
 */
public class LongerContiguousSegmentsOfOnesThanZeros {

    public boolean checkZeroOnes(String s) {
        return longerLengthOfCharacter(s, '1') > longerLengthOfCharacter(s, '0');
    }

    private int longerLengthOfCharacter(String s, char c) {
        int maxLen = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int len = 0;
            while (i < n && s.charAt(i) == c) {
                i++;
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

}
