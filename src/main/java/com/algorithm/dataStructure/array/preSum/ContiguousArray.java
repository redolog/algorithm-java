package com.algorithm.dataStructure.array.preSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * <p>
 * https://leetcode.cn/problems/contiguous-array/
 *
 * @author dragonsong  @date 2022/7/11
 */
public class ContiguousArray {

    static class PreSum {

        /**
         * 执行用时：
         * 48 ms
         * , 在所有 Java 提交中击败了
         * 5.69%
         * 的用户
         * 内存消耗：
         * 49.8 MB
         * , 在所有 Java 提交中击败了
         * 85.99%
         * 的用户
         * 通过测试用例：
         * 564 / 564
         */

        public int findMaxLength(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> preSum2StartIdx = new HashMap<>();
            preSum2StartIdx.put(0, 0);

            int maxLen = 0;
            int preSum = 0;
            for (int i = 0; i < n; i++) {
                // 计算前缀和
                preSum += zero2Negative(nums[i]);

                // 前缀和下标位置
                int preSumIdx = i + 1;
                // 前置已经有前缀和与当前前缀和一致时，计算间距
                Integer startIdx = preSum2StartIdx.get(preSum);
                if (startIdx != null && startIdx != preSumIdx) {
                    maxLen = Math.max(maxLen, preSumIdx - startIdx);
                }

                preSum2StartIdx.putIfAbsent(preSum, preSumIdx);
            }
            return maxLen;
        }

        private int zero2Negative(int num) {
            return 0 == num ? -1 : num;
        }
    }

    static class PreSumArr {
        /*
         * 执行用时：
         * 43 ms
         * , 在所有 Java 提交中击败了
         * 5.69%
         * 的用户
         * 内存消耗：
         * 48.9 MB
         * , 在所有 Java 提交中击败了
         * 99.28%
         * 的用户
         * 通过测试用例：
         * 564 / 564
         */

        /**
         * 前缀和计算：
         * 将0视为-1，计算前缀和时，和等于0时，满足题干所求情况。
         * 多个前缀和等于0时，判断最大间距即可。
         */
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            int[] preSumArr = new int[n + 1];
            // 记录某前缀和最开始出现的位置，idx表示 preSumArr 中的下标
            Map<Integer, Integer> preSum2StartIdx = new HashMap<>();
            preSum2StartIdx.put(0, 0);

            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                int preSumIdx = i + 1;
                preSumArr[preSumIdx] = preSumArr[i] + replaceZero(nums[i]);

                // 前缀和a - 前缀和b == 0 时，说明中间区间01成对
                // 当前前缀和
                int preSumCurr = preSumArr[preSumIdx];
                if (preSum2StartIdx.containsKey(preSumCurr) && preSum2StartIdx.get(preSumCurr) != preSumIdx) {
                    maxLen = Math.max(maxLen, preSumIdx - preSum2StartIdx.get(preSumCurr));
                }

                preSum2StartIdx.putIfAbsent(preSumArr[preSumIdx], preSumIdx);
            }

            return maxLen;
        }

        /**
         * 将0视为-1
         */
        private int replaceZero(int num) {
            return num == 1 ? 1 : -1;
        }
    }


}
