package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/remove-one-element-to-make-the-array-strictly-increasing/
 *
 * @author songhuilong  @date 2022/10/28
 */
public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        // 思路：遍历两次：
        // 1. 找到可能被删掉的值
        // 2. 分别去掉两个可能被删掉值，判断数组是否严格递增
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return strictlyIncreasingExceptIdx(nums, i) || strictlyIncreasingExceptIdx(nums, i + 1);
            }
        }
        return true;
    }

    /**
     * 除了 nums[deleteIdx] ，数组是否整体严格递增
     */
    private boolean strictlyIncreasingExceptIdx(int[] nums, int deleteIdx) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int curr = i, prev = i - 1;
            if (prev == deleteIdx) {
                if (prev >= 1) {
                    prev = prev - 1;
                } else {
                    // deleteIdx在0的位置，考察后续序列即可
                    continue;
                }
            } else if (curr == deleteIdx) {
                if (curr < n - 1) {
                    curr = curr + 1;
                } else {
                    // deleteIdx已经到了最后一项
                    return true;
                }
            }
            if (nums[prev] >= nums[curr]) {
                return false;
            }
        }
        return true;
    }
//    /**
//     * 除了 nums[deleteIdx] ，数组是否整体严格递增
//     */
//    private boolean strictlyIncreasingExceptIdx(int[] nums, int deleteIdx) {
//        int n = nums.length;
//        for (int i = 1; i < n - 1; i++) {
//            int curr = i, prev = i - 1, next = curr + 1;
//            if (curr == deleteIdx) {
//                if (next + 1 < n) {
//                    curr = next;
//                    next = next + 1;
//                } else {
//                    if (nums[prev] >= nums[next]) {
//                        return false;
//                    }
//                    continue;
//                }
//            } else if (prev == deleteIdx) {
//                if (prev - 1 >= 0) {
//                    prev = prev - 1;
//                } else {
//                    if (nums[curr] >= nums[next]) {
//                        return false;
//                    }
//                    continue;
//                }
//            } else if (next == deleteIdx) {
//                if (next + 1 < n) {
//                    next = next + 1;
//                } else {
//                    if (nums[prev] >= nums[curr]) {
//                        return false;
//                    }
//                    continue;
//                }
//            }
//            // 谷底值
//            if (nums[curr] <= nums[prev] && nums[curr] <= nums[next]) {
//                return false;
//            }
//            // 峰值
//            if (nums[curr] >= nums[prev] && nums[curr] >= nums[next]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
