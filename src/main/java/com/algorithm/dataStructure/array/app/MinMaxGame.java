package com.algorithm.dataStructure.array.app;

/**
 * https://leetcode.cn/problems/min-max-game/
 *
 * @author songhuilong001  @date 2023/1/15
 */
public class MinMaxGame {

    static class InPlacementSolution {
        /**
         * 在原入参数组上完成所有操作，不开辟新的空间
         */
        public int minMaxGame(int[] nums) {
            int n = nums.length, newN = n / 2;
            while (n > 1) {
                for (int i = 0; i < newN; i++) {
                    if ((i & 1) == 0) {
                        nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                    } else {
                        nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                    }
                }
                n = newN;
                newN = n / 2;
            }
            return nums[0];
        }
    }

    static class LoopSolution {
        public int minMaxGame(int[] nums) {
            while (true) {
                int n = nums.length, newN = n / 2;
                if (n == 1) {
                    return nums[0];
                }
                int[] newNums = new int[newN];
                for (int i = 0; i < newN; i++) {
                    if ((i & 1) == 0) {
                        newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                    } else {
                        newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                    }
                }
                nums = newNums;
            }
        }
    }

    static class RecursionSolution {
        public int minMaxGame(int[] nums) {
            int n = nums.length, newN = n / 2;
            if (n == 1) {
                return nums[0];
            }
            int[] newNums = new int[newN];
            for (int i = 0; i < newN; i++) {
                if ((i & 1) == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            return minMaxGame(newNums);
        }
    }
}
