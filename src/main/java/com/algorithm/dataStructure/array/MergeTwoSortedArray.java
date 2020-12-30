package com.algorithm.dataStructure.array;

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
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // i表示1的下标，j表示2的下标
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (nums1[i] <= nums2[j]) {
                // 1继续迭代，2不动，待与下一轮与1中元素对比
                i++;
            } else {
                m = ++m;
                // 2中元素（更小）占据i位置，1其余元素后移
                for (int i1 = m - i; i1 >= i; i1--) {
                    nums1[i1 + 1] = nums1[i1];
                }
                nums1[i] = nums2[j];
                j++;
            }
        }
    }
}
