package com.algorithm.decimal;

import java.util.stream.IntStream;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 * <p>
 * https://leetcode.cn/problems/qiu-12n-lcof/
 *
 * @author dragonsong  @date 2022/6/17
 */
public class SumNums {

    public int sumNums(int n) {
        boolean b = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int sumNumsWithStream(int n) {
        return IntStream.range(0, n + 1).sum();
    }
}
