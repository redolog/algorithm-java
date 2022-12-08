package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/add-digits/
 *
 * @author songhuilong001  @date 2022/12/8
 */
public class AddDigits {

    static class Iteration {
        public int addDigits(int num) {
            while (num > 9) {
                int sum = 0;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                num = sum;
            }
            return num;
        }
    }

    static class Math {
        /**
         * 9的倍数，各个位加起来的和，还是9的倍数，并且更小
         */
        public int addDigits(int num) {
            if (num > 0 && num % 9 == 0) {
                return 9;
            }
            // (num - 1) % 9 + 1
            return num % 9;
        }
    }
}
