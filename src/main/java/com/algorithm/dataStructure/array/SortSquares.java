package com.algorithm.dataStructure.array;

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
 *
 * @author DragonSong  @date 2021/3/16
 */
public class SortSquares {

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int len = nums.length;
        int[] ans = new int[len];

        // 双指针，i从头开始，j从尾开始
        for (int i = 0, j = len - 1, insertPosition = len - 1; i <= j; ) {
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if (left > right) {
                ans[insertPosition] = left;
                ++i;
            } else {
                ans[insertPosition] = right;
                --j;
            }
            // 倒序插入到ans
            --insertPosition;
        }
        return ans;
    }
}
