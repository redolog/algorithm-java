package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 *
 * @author songhuilong  @date 2022/10/24
 */
public class PartitionArrayIntoDisjointIntervals {

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        // 右侧每个元素记录最小值
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        // 左侧每个元素记录左区间最大元素
        int[] leftMax = new int[n];
        for (int i = 0; i < n - 1; i++) {
            leftMax[i] = i == 0 ? nums[i] : Math.max(leftMax[i - 1], nums[i]);
            // left 中的每个元素都小于或等于 right 中的每个元素。
            // left当前元素左区间最大值 小于等于 right当前元素右区间最小值
            if (leftMax[i] <= rightMin[i + 1]) {
                return i + 1;
            }
        }
        return 1;
    }

}
