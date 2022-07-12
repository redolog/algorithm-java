package com.algorithm.dataStructure.array;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * https://leetcode.cn/problems/maximum-subarray/
 *
 * @author dragonsong  @date 2022/7/12
 */
public class MaximumSubarray {

    static class BF {
        /**
         * 暴力枚举：以每个元素为新数组开始，逐个往后求和，比较得出和最大值
         */
        public int maxSubArray(int[] nums) {
            int n = nums.length;

            int ans = nums[0];
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < n; j++) {
                    sum += nums[j];
                    ans = Math.max(ans, sum);
                }
            }
            return ans;
        }
    }

    static class DP {
        /*
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 50.7 MB
         * , 在所有 Java 提交中击败了
         * 40.49%
         * 的用户
         * 通过测试用例：
         * 209 / 209
         */

        /**
         * liweiwei 这个题解让我第一次懂了 DP：https://leetcode.cn/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
         * <p>
         * <p>
         * 解题关键：
         * 定义 dp[i] 表示i元素结尾的子数组最大和
         * dp[i-1]为正数时，dp[i]=dp[i-1]+nums[i]，因此正数对求和是正向作用，反之，dp[i-1]为0、负数时，dp[i]=nums[i]
         * 同时，dp[0]=nums[0]，因为第一个元素子数组只能有 nums[0] 元素
         * <p>
         * 为什么  dp[i] 不能表示为i元素开头的子数组最大和？
         * 其实也可以，nums 逆序遍历即可。但是正向遍历时， dp[i]表示i开头的子数组间，无法关联子问题。
         */
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];

            int ans = dp[0];

            // 从第二个元素开始遍历
            for (int i = 1; i < n; i++) {
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                } else {
                    dp[i] = nums[i];
                }

                ans = ans > dp[i] ? ans : dp[i];
            }
            return ans;
        }
    }


}
