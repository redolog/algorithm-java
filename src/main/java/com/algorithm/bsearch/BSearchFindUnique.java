package com.algorithm.bsearch;


/**
 * 这道题可以用 xor 取巧来解，但是二分的方式更考察逻辑，更实用
 *
 * @author dragonsong  @date 2022/5/10
 */
public class BSearchFindUnique {

    /**
     * 一个排好序的数组，每个数字都重复出现2次，除了有1个数只出现一次，请你用二分查找O(logn)的方法找出来。
     * 比如
     * 输入：{1, 1, 3, 3, 4, 4, 5},
     * 返回：5
     * <p>
     * int getStranger(int[] vals){
     * <p>
     * 直接将找到的值返回
     * }
     */
    public static int bsearchFindUnique(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        // 解题关键：中间值与前一个值相等时：
        //  1. middle为偶数，说明唯一值在左区间；
        //  2. middle为奇数，说明唯一值在右区间；
        while (low <= high) {
            int middle = low + ((high - low) >> 1);

            // 边界
            if (middle == 0 || middle == nums.length - 1) {
                return nums[middle];
            }

            if (nums[middle] == nums[middle - 1]) {
                if (middle % 2 == 0) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else if (nums[middle] == nums[middle + 1]) {
                if (middle % 2 == 0) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else {
                return nums[middle];
            }

        }
        // 不存在目标，返回-1
        return -1;
    }
}
