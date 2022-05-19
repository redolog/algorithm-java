package com.algorithm.flow;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 * Easy
 * <p>
 * 1642
 * <p>
 * 107
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an integer num, return the number of steps to reduce it to zero.
 * <p>
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 14
 * Output: 6
 * Explanation:
 * Step 1) 14 is even; divide by 2 and obtain 7.
 * Step 2) 7 is odd; subtract 1 and obtain 6.
 * Step 3) 6 is even; divide by 2 and obtain 3.
 * Step 4) 3 is odd; subtract 1 and obtain 2.
 * Step 5) 2 is even; divide by 2 and obtain 1.
 * Step 6) 1 is odd; subtract 1 and obtain 0.
 * Example 2:
 * <p>
 * Input: num = 8
 * Output: 4
 * Explanation:
 * Step 1) 8 is even; divide by 2 and obtain 4.
 * Step 2) 4 is even; divide by 2 and obtain 2.
 * Step 3) 2 is even; divide by 2 and obtain 1.
 * Step 4) 1 is odd; subtract 1 and obtain 0.
 * Example 3:
 * <p>
 * Input: num = 123
 * Output: 12
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= num <= 106
 * <p>
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 *
 * @author dragonsong  @date 2022/5/17
 */
public class ReduceNumberToZero {

    public static int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            ++step;
            num = num % 2 == 0 ? num / 2 : num - 1;

        }
        return step;
    }

    public static int numberOfSteps2(int num) {
        int step = 0;
        while (num > 0) {
            ++step;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return step;
    }

}
