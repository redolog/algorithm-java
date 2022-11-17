package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/
 *
 * @author songhuilong001  @date 2022/11/17
 */
public class CountOddNumbersInAnIntervalRange {

    public int countOdds(int low, int high) {
        // 数字数量
        int cnt = high - low + 1;
        int ans = cnt / 2;
        // 偶数个，一定有一半是奇数
        if (even(cnt)) {
            return ans;
        }
        // 奇数个，观察用例 1、2、3 与 2、3、4
        // 发现首位均为奇数时需ans+=1
        ans += odd(low) && odd(high) ? 1 : 0;
        return ans;
    }

    private boolean odd(int num) {
        return (num & 1) == 1;
    }

    private boolean even(int num) {
        return (num & 1) == 0;
    }

}
