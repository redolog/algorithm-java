package com.algorithm.dataStructure.array.preSum;


/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * <p>
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
 * 包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 * <p>
 * https://leetcode.cn/problems/range-sum-query-immutable/
 *
 * @author dragonsong  @date 2022/7/1
 */
public class RangeSumQueryImmutable {

    /*
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 44.2 MB
     * , 在所有 Java 提交中击败了
     * 49.47%
     * 的用户
     * 通过测试用例：
     * 15 / 15
     */

    int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        this.sums = new int[nums.length];
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            this.sums[i] = preSum;
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? sums[right] : sums[right] - sums[left - 1];
    }
}
