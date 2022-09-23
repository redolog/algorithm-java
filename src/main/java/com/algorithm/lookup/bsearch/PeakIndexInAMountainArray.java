package com.algorithm.lookup.bsearch;

/**
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 *
 * @author songhuilong  @date 2022/9/23
 */
public class PeakIndexInAMountainArray {

    static class Traversal {
        /**
         * 逐个遍历，时间复杂度：O(n)
         */
        public int peakIndexInMountainArray(int[] arr) {
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class BSearch {
        /**
         * 二分查找：跳跃到某点时，如果该点与左右两个点整体上升趋势，说明此时在左区间，需要往右跳，反之亦然，如果此时该点为顶峰，可直接返回
         * 整体时间复杂度：O(logn)
         */
        public int peakIndexInMountainArray(int[] arr) {
            int n = arr.length;
            int l = 0, r = n - 1;

            while (true) {
                int mid = l + ((r - l) >> 1);
                // 题目保证入参一定为合法的mountainArray，这里对边界做一个guard
                if (mid == 0) {
                    mid = 1;
                }
                if (mid == n - 1) {
                    mid = n - 2;
                }
                if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                    return mid;
                }
                if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                    // 上升趋势，往右跳
                    l = mid + 1;
                } else {
                    // 下降趋势，往左跳
                    r = mid - 1;
                }
            }
        }
    }

}
