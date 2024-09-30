package com.algorithm.dataStructure.array.majorityElement;

/**
 * <a href="https://leetcode.cn/problems/majority-element">找众数</a>
 * <p>
 * 1. 直观解法：使用map计数，计数最大的，即为众数，空间复杂度O(n);
 * 2. 摩尔投票解法：进行投票，与基准数不同时，票数-1，重复此过程，在剩余区间中，众数的优势会被放大，而非众数的优势则越来越小；不使用额外的空间，空间复杂度O(1);
 *
 * @author songhuilong  @date 2024/9/30
 */
public class MajorityElement {

    /**
     * 摩尔投票，可以在不借助外部空间的情况下，找到数组中的众数：
     * <p>
     * 从当前位置取一个数为基准数
     * 逐个元素进行投票，与基准数不同时则互相抵消投票数-1，与基准数相同时则增加投票+1
     * 原理：题目已知入参数组中一定存在众数，那么初始基准数就有两种情况：
     * 1. 初始基准数为众数，那么往后抵消，剩余的区间中，众数一定还有一半及以上，因此可重复投票过程
     * 2. 初始基准数不是众数，那么往后抵消，要么抵消了一个众数，与1.情况一致，要么抵消了非众数，此时剩余元素中众数更多（优势更大）
     * 重复上述过程，最后的基准数一定会留给众数，即所求答案
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int vote = 0;

        for (int num : nums) {
            if (vote == 0) {
                // 当前票数为0，说明上一轮进行了抵消，接着只需判断剩余区间，选中首个元素为基准数
                candidate = num;
            }
            vote += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
