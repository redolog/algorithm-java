package com.algorithm.string;

/**
 * https://leetcode.cn/problems/count-number-of-homogenous-substrings/
 *
 * @author songhuilong  @date 2022/12/26
 */
public class CountNumberOfHomogenousSubstrings {

    /**
     * 等差数列求和：n*(n+1)/2
     * 同构计数，本质上是连续相同的字符为一组，一组的同构数为字符数的等差数列求和
     */
    public int countHomogenous(String s) {
        int n = s.length(),
                // 一组同构字符内的字符数
                groupCnt = 1,
                // 对大数进行 1e7 取余
                mod = 1000000007;
        // 总和
        long ans = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char curr = s.charAt(i);
            if (prev == curr) {
                groupCnt++;
            } else {
                ans += (long) (groupCnt + 1) * groupCnt / 2;
                // 下一组就位
                groupCnt = 1;
                prev = curr;
            }
        }
        ans += (long) (groupCnt + 1) * groupCnt / 2;
        return (int) (ans % mod);
    }
}
