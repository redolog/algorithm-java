package com.algorithm.dataStructure.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author dragonsong  @date 2022/6/12
 */
public class FindRepeatNumber {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 48.5 MB
     * , 在所有 Java 提交中击败了
     * 83.48%
     * 的用户
     * 通过测试用例：
     * 25 / 25
     *
     */
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        // 将nums数据有序化，对齐 i下标与iVal
        int i = 0;
        // 每次将 nums[i]下标的数据归位
        while (i < n) {
            if (nums[i] == i) {
                // 当前i位置值已经有序化
                ++i;
                continue;
            }
            // nums[i]下标的数据归位
            int tmp = nums[nums[i]];
            if (tmp == nums[i]) {
                // 当前nums[i]位置的值已经等于了i位置的值，说明是之前替换或者本来就有序就位的，为所求重复项
                return nums[i];
            }

            nums[nums[i]] = nums[i];
            nums[i] = tmp;
        }
        return -1;
    }

    /*
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 32.53%
     * 的用户
     * 内存消耗：
     * 50 MB
     * , 在所有 Java 提交中击败了
     * 35.51%
     * 的用户
     * 通过测试用例：
     * 25 / 25
     */
    public int findRepeatNumberWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
