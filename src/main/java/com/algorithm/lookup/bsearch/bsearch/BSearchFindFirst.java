package com.algorithm.lookup.bsearch.bsearch;


/**
 * 给出一个有序数组，请在数组中找出目标值的起始位置
 * <p>
 * 你的算法的时间复杂度应该在O(log n)之内
 * 如果数组中不存在目标，返回-1.
 * 例如：
 * 给出的数组是[50, 70, 70, 80, 80, 100]，目标值是80,
 * 返回3.
 * 示例1
 * 输入： [50, 70, 70, 80, 80, 100],80
 * 输出： 3
 *
 * @author dragonsong  @date 2022/5/10
 */
public class BSearchFindFirst {

    public static int bsearchFindFirst(int[] nums, int target) {

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
                if (middle == 0 || nums[middle - 1] < target) {
                    return middle;
                } else {
                    // 往前查找
                    high = middle - 1;
                }
            }
        }


        // 不存在目标，返回-1
        return -1;
    }


}
