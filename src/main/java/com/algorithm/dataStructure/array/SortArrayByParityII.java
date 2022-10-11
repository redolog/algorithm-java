package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/sort-array-by-parity-ii/
 *
 * @author songhuilong  @date 2022/10/11
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        // even找偶数位但是数值为奇数的
        // odd找奇数位但是数值为偶数的
        int even = 0, odd = 1, n = nums.length;
        while (even < n && odd < n) {
            while (even < n && (nums[even] & 1) == 0) {
                even += 2;
            }
            while (odd < n && (nums[odd] & 1) == 1) {
                odd += 2;
            }
            if (even >= n || odd >= n) {
                break;
            }
            swap(nums, even, odd);
        }
        return nums;
    }

    private void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
