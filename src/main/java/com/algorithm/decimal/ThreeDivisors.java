package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/three-divisors/
 *
 * @author songhuilong  @date 2023/2/10
 */
public class ThreeDivisors {

    public boolean isThree(int n) {
        int cnt = 2;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                cnt++;
            }
            if (cnt > 3) {
                return false;
            }
        }
        return cnt == 3;
    }
}
