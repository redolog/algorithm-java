package com.algorithm.dataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 * <p>
 * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 * <p>
 * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 * <p>
 * 注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,10,9,8]
 * 输出：[10,9]
 * 解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,7,6,7]
 * 输出：[7,7,6]
 * 解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。
 * 示例 3：
 * <p>
 * 输入：nums = [6]
 * 输出：[6]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 *
 * @author dragonsong  @date 2022/8/4
 */
public class MinimumSubsequenceInNonIncreasingOrder {

    /*
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 95.47%
     * 的用户
     * 内存消耗：
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 90.37%
     * 的用户
     * 通过测试用例：
     * 103 / 103
     */

    /**
     * 先排序，按降序顺序遍历，逐步将大元素放到ansList
     */
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 子序列的元素之和 严格 大于未包含在该子序列中的各元素之和
        int subSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            subSum += nums[i];
            sum -= nums[i];
            ans.add(nums[i]);
            if (subSum > sum) {
                break;
            }
        }

        return ans;
    }
}
