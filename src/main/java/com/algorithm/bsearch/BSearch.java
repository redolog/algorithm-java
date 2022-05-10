package com.algorithm.bsearch;


/**
 * 朴素二分查找
 *
 * @author dragonsong  @date 2022/5/10
 */
public class BSearch {

    public static int bsearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] > target) {
                // 重置右边界
                high = middle - 1;
            } else if (nums[middle] < target) {
                // 重置左边界
                low = middle + 1;
            } else {
                return nums[middle];
            }
        }

        // 不存在返回-1
        return -1;
    }

    public static int bsearchRecursive(int[] nums, int target) {
        return bsearchRecursive(nums, 0, nums.length - 1, target);
    }

    private static int bsearchRecursive(int[] array, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (array[mid] == value) {
            return array[mid];
        } else if (array[mid] < value) {
            return bsearchRecursive(array, mid + 1, high, value);
        } else {
            return bsearchRecursive(array, low, mid - 1, value);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 5, 6, 7, 8, 8};
        System.out.println(bsearchRecursive(array, 0, array.length - 1, 6));
    }


}
