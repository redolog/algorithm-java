package com.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author dragonsong  @date 2022/6/19
 */
public class FibonacciSequence {

    Map<Integer, Integer> cache = new HashMap<Integer, Integer>() {{
        put(0, 0);
        put(1, 1);
    }};

    public int fib(int n) {
        return recurse(n);
    }

    private int recurse(int n) {
        if (n == 0 || n == 1) {
            return cache.get(n);
        }
        int nSubtract1 = cache(n, 1);
        int nSubtract2 = cache(n, 2);
        return nSubtract1 + nSubtract2;
    }

    private int cache(int n, int x) {
        int val;
        if (cache.containsKey(n - x)) {
            val = cache.get(n - x);
        } else {
            val = recurse(n - x);
            cache.put(n - x, val);
        }
        return val;
    }


}
