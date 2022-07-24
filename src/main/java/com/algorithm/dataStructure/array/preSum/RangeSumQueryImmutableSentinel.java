package com.algorithm.dataStructure.array.preSum;


/**
 * 使用哨兵的写法，统一化编码
 *
 * @author dragonsong  @date 2022/7/1
 */
public class RangeSumQueryImmutableSentinel {

    int[] sums;

    public RangeSumQueryImmutableSentinel(int[] nums) {
        // sums下标统一后移一位，空间 n+1
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        // 读取时下标也右移一位，left++之后，读取的时候也要 left-1，所以不做操作
        right++;
        return sums[right] - sums[left];
    }
}
