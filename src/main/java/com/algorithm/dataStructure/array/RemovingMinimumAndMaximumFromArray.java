package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/removing-minimum-and-maximum-from-array/
 *
 * @author songhuilong  @date 2022/9/13
 */
public class RemovingMinimumAndMaximumFromArray {

    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        if (n <= 3) {
            return 2;
        }

        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        // 找到最大值最小值位置，三种情况：两个全在前半段、两个全在后半段、一个在前一个在后，三个距离取最小值即可
        int firstHalf = Math.max(minIdx, maxIdx) + 1;
        int latterHalf = Math.max(n - minIdx, n - maxIdx);
        int firstAndLatter = Math.min(minIdx + 1, n - minIdx) + Math.min(maxIdx + 1, n - maxIdx);
        return Math.min(Math.min(firstAndLatter, firstHalf), latterHalf);
    }
}
