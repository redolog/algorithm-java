package com.algorithm.string;

/**
 * https://leetcode.cn/problems/determine-if-string-halves-are-alike/
 *
 * @author songhuilong  @date 2022/11/11
 */
public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        String vowelStr = "aeiouAEIOU";
        // 使用long64位存储元音字母
        long int64 = 0L;
        for (int i = 0; i < vowelStr.length(); i++) {
            int64 |= (1L << vowelStr.charAt(i) - 'A');
        }
        int n = s.length();
        return cntStrRange(s, 0, n / 2 - 1, int64) == cntStrRange(s, n / 2, n - 1, int64);
    }

    private int cntStrRange(String str, int l, int r, long vowelBit) {
        int vowelCnt = 0;
        for (int i = l; i <= r; i++) {
            if ((vowelBit & (1L << str.charAt(i) - 'A')) != 0) {
                vowelCnt++;
            }
        }
        return vowelCnt;
    }
}
