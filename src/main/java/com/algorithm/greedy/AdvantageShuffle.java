package com.algorithm.greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 870. 优势洗牌
 * https://leetcode.cn/problems/advantage-shuffle/
 *
 * @author songhuilong  @date 2022/10/8
 */
public class AdvantageShuffle {

    static class SortedMapSolution {

        /**
         * SortBinarySearch 解法中每一轮使用remove移除用掉的元素，整体复杂度 n^2
         * <p>
         * 这里我们考虑使用跳表或者红黑树的结构来优化查找、删除元素的效率，整体复杂度 n*logn
         */
        public int[] advantageCount(int[] nums1, int[] nums2) {
            NavigableMap<Integer, Integer> num2Cnt = new TreeMap<>();
            for (int num : nums1) {
                num2Cnt.put(num, num2Cnt.getOrDefault(num, 0) + 1);
            }

            // j表示ans插入下标
            int n = nums1.length, j = 0;
            int[] ans = new int[n];
            for (int num : nums2) {
                // 找严格比num大的
                Integer bigger = num2Cnt.higherKey(num);
                if (bigger == null) {
                    // 没有比num大的，则找一个最小值出来
                    bigger = num2Cnt.firstKey();
                }
                ans[j++] = bigger;
                Integer cnt = num2Cnt.get(bigger);
                if (cnt == 1) {
                    num2Cnt.remove(bigger);
                } else {
                    num2Cnt.put(bigger, cnt - 1);
                }
            }
            return ans;
        }
    }

    static class SortBinarySearch {
        /**
         * 题干翻译：
         * - nums2不动；
         * - 依次对nums2元素遍历，对每一个nums2的元素，从nums1中找出 nums1[i] > nums2[i] 且nums1[i]为最接近nums2[i]的值，即大于且距离最近（贪心）；
         * <p>
         * 方案：
         * - 对 nums1 升序排序
         * - 每一个nums2元素为target，在排序后的nums1中进行二分查找，同时找到元素后将元素标记为不可用状态
         * <p>
         * 时间复杂度：排序开销 + 每一轮移除一个用掉的元素，O(n*logn + n^2)
         * 空间复杂度：不修改入参数组的情况下开辟了一个nums1大小的新数组，O(n)
         */
        public int[] advantageCount(int[] nums1, int[] nums2) {
            // 排序
            List<Integer> nums1List = Arrays.stream(nums1).boxed().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            // j表示ans插入下标
            int n = nums1.length, j = 0;
            int[] ans = new int[n];
            for (int num : nums2) {
                int greaterTarget = greaterThanTarget(nums1List, num);
                if (greaterTarget == -1) {
                    ans[j++] = nums1List.get(0);
                    nums1List.remove(0);
                } else {
                    ans[j++] = nums1List.get(greaterTarget);
                    // 标记为不可用状态
                    nums1List.remove(greaterTarget);
                }
            }
            return ans;
        }

        /**
         * 二分查找数组中非-1且大于target的值
         * 返回对应下标
         *
         * @param list   升序排序数组
         * @param target 目标基准值
         * @return 不存在非-1且大于target的值时，返回-1
         */
        private int greaterThanTarget(List<Integer> list, int target) {
            int l = 0, r = list.size() - 1;
            if (target > list.get(r)) {
                return -1;
            }
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (list.get(mid) > target) {
                    // mid-1即更左元素已经小于了target
                    if (mid - 1 >= 0 && list.get(mid - 1) <= target) {
                        return mid;
                    }
                    // mid已经到了最左
                    if (mid - 1 < l) {
                        return mid;
                    }
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return -1;
        }
    }


}
