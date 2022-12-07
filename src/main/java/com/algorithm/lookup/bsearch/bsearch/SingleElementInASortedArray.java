package com.algorithm.lookup.bsearch.bsearch;

/**
 * https://leetcode.cn/problems/single-element-in-a-sorted-array/
 *
 * @author songhuilong001  @date 2022/12/7
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (mid == 0 || mid == n - 1 || (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }
            if (mid % 2 == 0) {
                // 偶数下标，如果 mid与下一个数相等，说明前序都是成对的数，可以往右跳，否则往左跳
                if (nums[mid + 1] == nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                // 奇数下标，如果 mid与上一个数相等，说明前序都是成对的数，可以往右跳，否则往左跳
                if (nums[mid - 1] == nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
