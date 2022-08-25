package com.algorithm.lookup;


/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须尽可能减少整个过程的操作步骤。
 * <p>
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 * https://dragonsong.tech/posts/rd/algo/oj/leetcode/find-minimum-in-rotated-sorted-array/
 *
 * @author dragonsong  @date 2022/6/19
 */
public class FindMinimumInRotatedSortedArrayII {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.5 MB
     * , 在所有 Java 提交中击败了
     * 9.19%
     * 的用户
     * 通过测试用例：
     * 193 / 193
     */
    public int minArray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[r] > nums[mid]) {
                r = mid;
            } else if (nums[r] < nums[mid]) {
                l = mid + 1;
            } else {
                r = r - 1;
            }
        }
        return nums[l];
    }
}
