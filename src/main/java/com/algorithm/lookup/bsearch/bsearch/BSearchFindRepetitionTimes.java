package com.algorithm.lookup.bsearch.bsearch;


/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @author dragonsong  @date 2022/5/10
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class BSearchFindRepetitionTimes {

    /**
     * 使用二分查找的方式，查两次：
     * 1. 第一次查target最左的位置；
     * 2. 第二次查target最右的位置；
     *
     * @param nums   数组
     * @param target 目标值
     * @return 重复次数
     */
    public static int bsearchFindRepetitionTimes(int[] nums, int target) {

        int rightMostIndex = bsearchWithDirection(nums, target, false);
        int leftMostIndex = bsearchWithDirection(nums, target, true);

        if (rightMostIndex == -1 || leftMostIndex == -1) {
            return -1;
        }

        return rightMostIndex - leftMostIndex + 1;
    }

    /**
     * @param leftMost 控制最左最右，true为最左
     */
    private static int bsearchWithDirection(int[] nums, int target, boolean leftMost) {
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
                if (leftMost) {
                    if (middle == 0 || nums[middle - 1] < target) {
                        return middle;
                    } else {
                        // 往前查找
                        high = middle - 1;
                    }
                } else {
                    if (middle == nums.length - 1 || nums[middle + 1] > target) {
                        return middle;
                    } else {
                        // 往后查找
                        low = middle + 1;
                    }
                }
            }
        }
        // 不存在目标，返回-1
        return -1;
    }


}
