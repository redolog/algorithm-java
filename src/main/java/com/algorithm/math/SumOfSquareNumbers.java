package com.algorithm.math;


/**
 * 633. 平方数之和
 * <p>
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * @author songhuilong  @date 2024/11/4
 */
public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (int) Math.sqrt(c);
        while (a <= b) {
            long squareSum = a * a + b * b;
            if (squareSum == c) {
                return true;
            } else if (squareSum > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

}
