package com.algorithm.dataStructure.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 *
 * @author songhuilong  @date 2022/11/4
 */
public class MaximizeSumOfArrayAfterKNegations {

    /**
     * 将数据放入最小堆，依次对较小数取反
     * - 应尽可能将负数取反
     * - 负数取反完后
     * - 碰到0可退出流程
     * - 如果次数k为偶数，退出流程
     * - 如果次数k为奇数，对最小正数取反，然后退出流程
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int num : nums) {
            minHeap.offer(num);
        }
        while (k > 0) {
            if (minHeap.peek() > 0) {
                break;
            }
            if (minHeap.peek() == 0) {
                return sum(minHeap);
            }
            minHeap.offer(-minHeap.poll());
            k--;
        }
        if ((k & 1) == 0) {
            return sum(minHeap);
        }
        minHeap.offer(-minHeap.poll());
        return sum(minHeap);
    }

    private Integer sum(Queue<Integer> minHeap) {
        return Arrays.stream(minHeap.toArray(new Integer[0])).reduce(Integer::sum).orElse(-1);
    }

}
