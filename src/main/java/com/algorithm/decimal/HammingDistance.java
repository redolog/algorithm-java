package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/hamming-distance/
 *
 * @author songhuilong  @date 2022/10/14
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & 1) != (y & 1)) {
                ans++;
            }
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }
}
