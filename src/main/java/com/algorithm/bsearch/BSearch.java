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

    /**
     * 找数组中最左>=target的元素下标
     *
     * @param arr    已排序数组
     * @param target 目标数
     * @return 数组中最左>=target的元素下标
     */
    public static int findLeftMostBiggerEqualIndex(int[] arr, int target) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        int ansIdx = -1;

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] >= target) {
                right = middle - 1;
                ansIdx = middle;
            } else {
                // arr[middle] < target
                left = middle + 1;
            }
        }

        return ansIdx;
    }

    public static int findLeftMostBiggerEqualIndexRude(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return -1;
    }

}
