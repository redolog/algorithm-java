package com.algorithm.dataStructure.array.intersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 350. 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 *
 * @author songhuilong  @date 2022/9/28
 */
public class IntersectionOfTwoArraysII {

    static class SortSolution {
        /**
         * 将入参数组排序，按照合并有序数组的过程来处理
         * <p>
         * 时间复杂度：排序开销最大，O(n*logn)
         * 空间复杂度：使用了额外的list  O(n)
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            // nums1更小
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            // i遍历nums1，j遍历nums2
            int i = 0, j = 0;
            List<Integer> intersectionList = new ArrayList<>();
            while (i < nums1.length && j < nums2.length) {
                if (nums2[j] > nums1[i]) {
                    // 小数组当前元素不在nums2中，看nums1下一个元素
                    i++;
                } else if (nums2[j] < nums1[i]) {
                    // 大数组当前元素比nums1当前元素还小，看nums2下一个元素
                    j++;
                } else {
                    // nums2[j]==nums1[i]
                    // 两个数组元素相等，为交集元素
                    intersectionList.add(nums1[i]);
                    i++;
                    j++;
                }
            }

            int[] ans = new int[intersectionList.size()];
            for (int x = 0; x < intersectionList.size(); x++) {
                ans[x] = intersectionList.get(x);
            }
            return ans;
        }
    }

    static class MapSolution {
        /**
         * 时间复杂度：完整遍历两个数组一次，O(n)
         * 空间复杂度：使用了额外的list、map  O(n)
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> num2Cnt1 = Arrays.stream(nums1).boxed().collect(Collectors.toMap(num -> num, k -> 1, Integer::sum));
            Map<Integer, Integer> num2Cnt2 = Arrays.stream(nums2).boxed().collect(Collectors.toMap(num -> num, k -> 1, Integer::sum));

            List<Integer> ansList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : num2Cnt1.entrySet()) {
                Integer num = entry.getKey();
                Integer cnt = entry.getValue();
                if (num2Cnt2.containsKey(num)) {
                    int minCnt = Math.min(cnt, num2Cnt2.get(num));
                    for (int i = 0; i < minCnt; i++) {
                        ansList.add(num);
                    }
                }
            }
            int[] ans = new int[ansList.size()];
            for (int i = 0; i < ansList.size(); i++) {
                ans[i] = ansList.get(i);
            }
            return ans;
        }
    }

}
