package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 * <p>
 * <p>
 * 提示：
 * <p>
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 * @author DragonSong  @date 2020/12/29
 * @link {https://leetcode-cn.com/problems/merge-sorted-array/}
 */

public class MergeTwoSortedArray {
    public void bruteForce(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void back2Front(int[] nums1, int m, int[] nums2, int n) {
        // 遍历cursor
        int i = m + n - 1;
        // nums1向前下标
        m--;
        // nums2向前下标
        n--;
        while (n >= 0 && m >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }

    public static void main(String[] args) {
        new MergeTwoSortedArray().back2Front(new int[]{0, 0}, 1, new int[]{1}, 1);
    }
}
