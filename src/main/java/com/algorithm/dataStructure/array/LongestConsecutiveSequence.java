package com.algorithm.dataStructure.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 *
 * @author songhuilong  @date 2022/9/6
 */
public class LongestConsecutiveSequence {

    static class Hash {
        /**
         * 使用hashset存储去重的数字
         * 每一轮分别从一个子序列的起点开始计算
         * 取所有子序列中最长的即可
         * <p>
         * 时间复杂度：整体遍历两次nums长度，O(n)
         * 空间复杂度：使用了额外的set，空间开销 O(n)
         */
        public int longestConsecutive(int[] nums) {
            if (null == nums || nums.length == 0) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int ans = 1;
            for (int num : set) {
                if (set.contains(num - 1)) {
                    continue;
                }
                // 每个序列从起点开始，起点的含义：set中没有 start-1 的数
                int cnt = 1;
                while (set.contains(num + 1)) {
                    cnt++;
                    num++;
                }
                ans = Math.max(ans, cnt);
            }
            return ans;
        }
    }

    static class Sort {
        /**
         * 排序时间复杂度：O(n*logn)
         * 空间复杂度：排序使用的栈空间：O(logn)
         */
        public int longestConsecutive(int[] nums) {
            if (null == nums || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);

            int pre = Integer.MIN_VALUE;
            int ans = 1, seqLen = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == pre) {
                    continue;
                }
                if (nums[i] == pre + 1) {
                    seqLen += 1;
                    ans = Math.max(ans, seqLen);
                } else {
                    seqLen = 1;
                }

                pre = nums[i];
            }

            return ans;
        }
    }
}
