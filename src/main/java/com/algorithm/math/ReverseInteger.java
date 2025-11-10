package com.algorithm.math;


/**
 * https://leetcode.cn/problems/reverse-integer/
 *
 * @author songhuilong  @date 2025/11/10
 */
public class ReverseInteger {

    /**
     * 这个解法的缺陷：
     * 额外使用了StringBuilder、Long进行数值拼接、对比，空间开销较大
     */
    static class LongWrapSolution {
        public int reverse(int x) {
            // 算法概述：
            // x一直对10取余，可得当前值的个位，对10除法，可得个位以外的高位
            // 重复上述过程，一直到x为0
            // 使用StringBuilder拼接反转后的数，最终转化为long值，对比int最大最小值，处理大小值边界
            StringBuilder builder = new StringBuilder(x >= 0 ? "" : "-");
            while (x != 0) {
                builder.append(Math.abs(x % 10));
                x /= 10;
            }
            if (builder.length() == 0) {
                return 0;
            }

            long val = Long.parseLong(builder.toString());
            if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) val;
        }
    }

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                // 当前位数已经要超限了
                return 0;
            }
            ans = ans * 10 + x % 10;
            // 每轮循环中获取个位
            x /= 10;
        }
        return ans;
    }


}
