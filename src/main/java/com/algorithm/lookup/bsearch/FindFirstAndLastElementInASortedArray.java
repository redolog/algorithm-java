package com.algorithm.lookup.bsearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author dragonsong  @date 2022/7/26
 */
public class FindFirstAndLastElementInASortedArray {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 44.6 MB
     * , 在所有 Java 提交中击败了
     * 45.25%
     * 的用户
     * 通过测试用例：
     * 88 / 88
     */

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = bSearch(nums, target, true);
        ans[1] = bSearch(nums, target, false);
        return ans;
    }

    private int bSearch(int[] nums, int target, boolean first) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                if (first) {
                    if (mid == 0 || nums[mid - 1] < target) {
                        return mid;
                    }
                    r = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] > target) {
                        return mid;
                    }
                    l = mid + 1;
                }

            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                // nums[mid] < target
                l = mid + 1;
            }
        }
        return -1;
    }
}
