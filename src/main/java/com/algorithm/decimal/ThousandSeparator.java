package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/thousand-separator/
 *
 * @author songhuilong  @date 2022/9/27
 */
public class ThousandSeparator {

    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        // 3位加一个小数点
        int cnt = 3;
        while (n != 0) {
            if (cnt == 0) {
                ans.append(".");
                cnt = 2;
            } else {
                cnt--;
            }
            ans.append(n % 10);
            n /= 10;
        }

        return ans.reverse().toString();
    }
}
