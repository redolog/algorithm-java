package com.algorithm.decimal;

import java.util.stream.IntStream;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @author dragonsong  @date 2022/6/21
 */
public class PrintNBitMaxNumbers {

    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 21.03%
     * 的用户
     * 内存消耗：
     * 49.5 MB
     * , 在所有 Java 提交中击败了
     * 9.81%
     * 的用户
     * 通过测试用例：
     * 5 / 5
     */
    public int[] printNumbers(int n) {
        return IntStream
                .rangeClosed(1, (int) (Math.pow(10, n) - 1))
                .toArray();
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 72.43%
     * 的用户
     * 内存消耗：
     * 49.3 MB
     * , 在所有 Java 提交中击败了
     * 18.06%
     * 的用户
     * 通过测试用例：
     * 5 / 5
     */
    public int[] printNumbersBF(int n) {
        int maxNum = maxNum(n);
        int[] arr = new int[maxNum];
        for (int i = 0; i < maxNum; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public int maxNum(int n) {
        int max = 0;
        while (n > 0) {
            max = max * 10 + 9;
            --n;
        }
        return max;
    }
}
