package com.algorithm.decimal;

/**
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 * <p>
 * 提示：
 * <p>
 * -107 <= num <= 107
 * <p>
 * https://leetcode.cn/problems/base-7/
 *
 * @author dragonsong  @date 2022/7/7
 */
public class Base7 {

    static class Traversal {
        /*
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 74.64%
         * 的用户
         * 内存消耗：
         * 39.2 MB
         * , 在所有 Java 提交中击败了
         * 20.46%
         * 的用户
         * 通过测试用例：
         * 241 / 241
         */
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }

            boolean positive = num > 0;

            StringBuilder ans = new StringBuilder();
            while (num != 0) {
                int quotient = num / 7;
                int remainder = num % 7;

                ans.insert(0, positive ? remainder : -remainder);
                num = quotient;
            }
            return positive ? ans.toString() : "-" + ans;
        }
    }

    static class Recursion {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            boolean positive = num > 0;
            int quotient = num / 7;
            int remainder = num % 7;
            String ans = convertToBase7(quotient) + (positive ? remainder : -remainder);
            ans = ans.startsWith("0") ? ans.substring(1) : ans;
            ans = ans.startsWith("-") ? ans.substring(1) : ans;
            return positive ? ans : "-" + ans;
        }
    }


}
