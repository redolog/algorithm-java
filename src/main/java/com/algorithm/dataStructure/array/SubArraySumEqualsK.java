package com.algorithm.dataStructure.array;

import com.algorithm.util.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 * <p>
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * @author dragonsong  @date 2022/5/18
 */
public class SubArraySumEqualsK {

    public int subarraySumBruteForce(int[] nums, int k) {
        // 暴力解
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            // 逐个遍历原数组
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                // 逐个遍历i之后的数据，求和
                sum += nums[j];
                if (sum == k) {
                    ++cnt;
                }
            }
        }

        return cnt;
    }

    /**
     * 前缀和版本
     * 前缀和属于是优化了数据结构的思路
     * 1. 首次遍历提前计算各区段和【预计算】，方便后续直接相减，这里可以认为前缀和数组为缓存，减少后续再套一层循环
     * 2. 再遍历前缀和数组，两项差==k 的时候，说明有子数组和满足条件
     * <p>
     * 提交结果：
     * 执行用时：
     * 1906 ms
     * , 在所有 Java 提交中击败了
     * 5.05%
     * 的用户
     * 内存消耗：
     * 43.1 MB
     * , 在所有 Java 提交中击败了
     * 90.65%
     * 的用户
     * 通过测试用例：
     * 90 / 90
     * <p>
     * 说明时间复杂度较高，我们下方还是会有一个 n^2 循环，这里是否可考虑缓存？
     */
    public static int subarraySumPreSum(int[] nums, int k) {
        // 前缀和
        int cnt = 0;

        int[] preSums = new int[nums.length];
        // 首次遍历，生成前缀和数组
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 计算前缀和
            preSum += nums[i];
            preSums[i] = preSum;
        }
        // 此步可单元验证下前缀和数组的值
//        System.out.println(Arrays.toString(preSums));

        // 再遍历前缀和数组，做k等值判断
        for (int left = 0; left < preSums.length; left++) {
            // 外层循环表示左遍历指针，左遍历指针在一轮遍历中固定不变，移动右遍历指针
            int sum;
            for (int right = left; right < preSums.length; right++) {
                sum = right == left ? preSums[right] : preSums[right] - preSums[left];
                if (sum == k) {
                    // 只要右区间减去左区间等值，说明满足子数组和为k，同时继续遍历不跳出本轮循环，因为可能有的值为负数，子数组继续增长也有可能满足条件
                    ++cnt;
                }
            }
        }

        return cnt;
    }

    /**
     * 前缀和数组存的是原数组元素从下标0的位置到当前位置i的元素和；
     * 而 前缀和-k == 当前位置i元素和减去目标值后的和，如果这个差值在前面的前缀和中存在，说明子数组和==k，即满足题目条件；
     * 我们使用map来存 前缀和->出现次数 的映射；
     * <p>
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     * <p>
     * 执行用时：
     * 20 ms
     * , 在所有 Java 提交中击败了
     * 94.14%
     * 的用户
     * 内存消耗：
     * 43.8 MB
     * , 在所有 Java 提交中击败了
     * 75.22%
     * 的用户
     * 通过测试用例：
     * 90 / 90
     */
    public static int subarraySumPreSumMap(int[] nums, int k) {
        int cnt = 0;
        // 未开始遍历数组时，前缀和为0
        int preSum = 0;
        // 使用map存 前缀和->出现次数 的映射；
        Map<Integer, Integer> preSum2Cnt = new HashMap<>(MapUtils.capacity(nums.length));
        preSum2Cnt.put(preSum, 1);

        for (int num : nums) {
            preSum += num;
            // 前缀和-k == 当前位置i元素和减去目标值后的和，
            // 如果这个差值在前面的前缀和中存在，说明子数组和==k，即满足题目条件；
            cnt += preSum2Cnt.getOrDefault(preSum - k, 0);

            // 先判断当前位置-k的前缀和在map中是否已存在；再将当前前缀和放入map；
            preSum2Cnt.put(preSum, preSum2Cnt.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }


}
