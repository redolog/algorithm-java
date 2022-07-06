package com.algorithm.lookup.bsearch.bsearch;


/**
 * 二分变体：给定有序数组，查找最后一个小于、等于目标值的元素下标
 *
 * @author DragonSong  @date 2022/5/12
 */
public class BSearchFindLastSmallerOrEqual {

    /**
     * 过程描述：
     * 首先跳到中间位置，比较与target的关系：
     * - 如果比target大，说明数据在左区间，挪动high右下标；
     * - 如果比target小，说明数据在右区间，挪动low左下标；【每一轮需检查是否挪动到了最右 + middle+1的值是否已经大于了target】
     *
     * @param nums   给定的有序数组
     * @param target 目标值
     * @return 找到的最后一个小于等于target的值的下标
     */
    public static int bsearchFindLastSmallerOrEqual(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (nums[middle] > target) {
                // 左区间只管挪动
                high = middle - 1;
            } else if (nums[middle] <= target) {
                if (middle == nums.length - 1 || nums[middle + 1] > target) {
                    return middle;
                }
                low = middle + 1;
            }
        }

        // 不存在目标，返回-1
        return -1;
    }


}
