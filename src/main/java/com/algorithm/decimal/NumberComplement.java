package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/number-complement/
 *
 * @author songhuilong  @date 2022/10/25
 */
public class NumberComplement {

    public int findComplement(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            int remainder = num % 2;
            builder.append(Math.abs(remainder - 1));
            num /= 2;
        }
        // 此时builder表示num的补数二进制，从低位开始到高位结束
        int ans = 0;
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '1') {
                ans += Math.pow(2, i);
            }

        }
        return ans;
    }
}
