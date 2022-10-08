package com.algorithm.greedy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/peaks-and-valleys-lcci/
 *
 * @author songhuilong  @date 2022/10/8
 */
public class PeaksAndValleysLcci {

    /**
     * 时间复杂度：排序开销，O(n*logn)
     * 空间复杂度：额外开辟了一个数组，O(n)
     */
    public int[] wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sortArr = Arrays.copyOf(nums, n);
        Arrays.sort(sortArr);
        // j表示ans写入下标；l表示最小值下标；r表示最大值下标；
        int j = 0, l = 0, r = n - 1;
        while (j < n) {
            nums[j++] = sortArr[r--];
            if (j >= n) {
                break;
            }
            nums[j++] = sortArr[l++];
        }
        return nums;
    }

    /**
     * 时间复杂度：完整遍历一次数组，O(n)
     * 空间复杂度：无额外空间开销，O(1)
     */
    public int[] wiggleSort2(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            // 偶数下标为峰
            if (i % 2 == 0) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                // 奇数下标为谷
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
