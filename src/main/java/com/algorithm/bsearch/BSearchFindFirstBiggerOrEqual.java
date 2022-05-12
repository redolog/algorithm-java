package com.algorithm.bsearch;


/**
 * 二分变体：给定有序数组，查找第一个大于、等于目标值的元素下标
 *
 * @author DragonSong  @date 2022/5/12
 */
public class BSearchFindFirstBiggerOrEqual {

    /**
     * 过程描述：
     * 首先跳到中间位置，比较与target的关系：
     * - 如果比target大，说明数据在左区间，挪动high右下标；【每一轮需检查是否挪动到了最左 + middle-1的值是否已经小于了target】
     * - 如果比target小，说明数据在右区间，挪动low左下标；
     *
     * @param nums   给定的有序数组
     * @param target 目标值
     * @return 找到的第一个大于等于target的值的下标
     */
    public static int bsearchFindFirstBiggerOrEqual(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] >= target) {
                if (middle == 0 || nums[middle - 1] < target) {
                    return middle;
                }
                high = middle - 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            }
        }

        // 不存在目标，返回-1
        return -1;
    }


}
