package com.algorithm.dataStructure.tree.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * <p>
 * https://leetcode.cn/problems/find-median-from-data-stream/
 *
 * @author dragonsong  @date 2022/6/27
 */
public class MedianFinder {

    /**
     * 保存更小区间，这个区间存奇数个情况下多出来的数据
     */
    PriorityQueue<Integer> maxHeap;
    /**
     * 保存更大区间
     */
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            // 等量的情况：
            // 最大堆空时，先入最大堆
            // 最大堆不空，先入最小堆，从最小堆中取出最小元素入最大堆
            if (!maxHeap.isEmpty() && num > maxHeap.peek()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
            }
        } else {
            // 最大堆中小元素个数大于最小堆中的大元素个数
            // 最小堆空时，先入最大堆，从最大堆中取出最大元素入最小堆
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        int maxInSmallerRange = maxHeap.peek() == null ? 0 : maxHeap.peek();
        int minInBiggerRange = minHeap.peek() == null ? 0 : minHeap.peek();
        if (maxHeap.size() == minHeap.size()) {
            return (maxInSmallerRange + minInBiggerRange) / 2.0;
        }
        return maxInSmallerRange;
    }

    public void clear() {
        minHeap.clear();
        maxHeap.clear();
    }
}
