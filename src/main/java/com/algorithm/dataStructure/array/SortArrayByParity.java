package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/sort-array-by-parity/
 *
 * @author songhuilong  @date 2022/9/30
 */
public class SortArrayByParity {

    // 两个指针完整遍历一次数组：时间复杂度：O(n)
    // 空间复杂度：O(1)
    // 同时此算法是稳定的，避免挪动已有效的数据
    public int[] sortArrayByParity(int[] nums) {
        // 双指针：odd指向奇数，even指向偶数
        // odd从左开始找奇数，等待交换到右侧
        // even从右开始找偶数，等待交换到左侧
        // odd==even || odd>even 时，跳出
        int n = nums.length, odd = 0, even = n - 1;
        while (odd < even) {
            while (odd < n && nums[odd] % 2 == 0) {
                odd++;
            }
            while (even >= 0 && nums[even] % 2 == 1) {
                even--;
            }
            if (odd >= even) {
                break;
            }
            swap(nums, odd, even);
            odd++;
            even--;
        }
        return nums;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
