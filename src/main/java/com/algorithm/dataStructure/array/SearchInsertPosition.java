package com.algorithm.dataStructure.array;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author DragonSong  @date 2020/12/23
 * @link {https://leetcode-cn.com/problems/search-insert-position/}
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int end = nums.length - 1;
        int start = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                return mid;
            }
            if (start == end - 1) {
                return end;
            }
        }
        return -1;
    }

}
