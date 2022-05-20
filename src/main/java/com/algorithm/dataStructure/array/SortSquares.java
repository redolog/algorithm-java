package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * <p>
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 *
 * @author DragonSong  @date 2021/3/16
 */
public class SortSquares {

    public int[] sortedSquaresBruteForce(int[] nums) {
        // fail-fast
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 粗暴解思路最容易理解，遍历数组，求平方，再对其中元素排序
        int[] ansArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ansArr[i] = nums[i] * nums[i];
        }
        Arrays.sort(ansArr);
        return ansArr;
    }

    /**
     * 题干中已知数组已经经过排序，所以我们可以避免再次排序，提高效率
     */
    public int[] sortedSquaresTwoPointer(int[] nums) {
        /**
         * 定义两个指针
         * 最左指针从0下标开始
         * 最右指针从len-1下标开始
         *
         * 每一轮对比左右指针对应值，逆序存入新数组
         */
        int len = nums.length;
        int[] ansArr = new int[len];
        int insertPos = len - 1;
        for (int left = 0, right = len - 1; insertPos >= 0; ) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                ansArr[insertPos] = nums[right] * nums[right];
                --right;
            } else {
                ansArr[insertPos] = nums[left] * nums[left];
                ++left;
            }
            --insertPos;
        }
        return ansArr;

    }
//    public int[] sortedSquares(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return new int[]{};
//        }
//        int len = nums.length;
//        int[] ans = new int[len];
//
//        // 双指针，i从头开始，j从尾开始
//        for (int i = 0, j = len - 1, insertPosition = len - 1; i <= j; ) {
//            int left = nums[i] * nums[i];
//            int right = nums[j] * nums[j];
//            if (left > right) {
//                ans[insertPosition] = left;
//                ++i;
//            } else {
//                ans[insertPosition] = right;
//                --j;
//            }
//            // 倒序插入到ans
//            --insertPosition;
//        }
//        return ans;
//    }
}
