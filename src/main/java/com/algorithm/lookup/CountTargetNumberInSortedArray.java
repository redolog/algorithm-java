package com.algorithm.lookup;

/**
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @author songhuilong  @date 2022/11/3
 */
public class CountTargetNumberInSortedArray {

    public int search(int[] nums, int target) {
        int rightFirstIdx = findFirstWithDirection(nums, target, true);
        if (rightFirstIdx == -1) {
            return 0;
        }
        return rightFirstIdx - findFirstWithDirection(nums, target, false) + 1;
    }

    /**
     * 找从右、从左开始的 等于target的下标
     * <p>
     * 时间复杂度：O(logn)
     *
     * @param arr    已排序的数组
     * @param target 目标值
     * @param right  是否从右？
     * @return 没找到target则返回-1
     */
    private int findFirstWithDirection(int[] arr, int target, boolean right) {
        int n = arr.length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == target) {
                if (right) {
                    if (mid == n - 1 || arr[mid + 1] > target) {
                        return mid;
                    }
                    l = mid + 1;
                } else {
                    if (mid == 0 || arr[mid - 1] < target) {
                        return mid;
                    }
                    r = mid - 1;
                }
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
