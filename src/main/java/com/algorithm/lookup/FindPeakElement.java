package com.algorithm.lookup;

/**
 * https://leetcode.cn/problems/find-peak-element/
 *
 * @author songhuilong  @date 2022/11/18
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            // 左边界
            if (mid == 0) {
                return nums[mid] > nums[mid + 1] ? mid : mid + 1;
            }
            // 右边界
            if (mid == n - 1) {
                return nums[mid] > nums[mid - 1] ? mid : mid - 1;
            }
            // mid正好是峰值
            if (validMid(mid, n) && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // mid所在序列单调递增
            if (validMid(mid, n) && nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                l = mid + 1;
                continue;
            }
            // mid所在序列单调递减
            if (validMid(mid, n) && nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
                r = mid - 1;
                continue;
            }
            // mid所在序列不单调，任意往左右未超出边界的方向跳
            r = mid - 1;
        }
        return l;
    }

    private boolean validMid(int mid, int n) {
        return mid - 1 >= 0 && mid + 1 < n;
    }
}
