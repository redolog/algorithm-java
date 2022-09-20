package com.algorithm.decimal;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/largest-number-after-digit-swaps-by-parity/
 *
 * @author songhuilong  @date 2022/9/20
 */
public class LargestNumberAfterDigitSwapsByParity {

    /**
     * 使用两个最大堆，分别维护奇偶数，降序
     * 借助原num，逐位填充队列已排好序的值
     */
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        // 最大堆：堆顶为最大值
        Queue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> even = new PriorityQueue<>(Comparator.reverseOrder());
        for (char c : arr) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                even.offer(digit);
            } else {
                odd.offer(digit);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : arr) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                builder.append(even.poll());
            } else {
                builder.append(odd.poll());
            }
        }
        return Integer.parseInt(builder.toString());
    }
}
