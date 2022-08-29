package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/shuffle-the-array/
 *
 * @author dragonsong  @date 2022/8/29
 */
public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    static class BitInplace {
        /**
         * 使用位运算在int 32位上操作，不开辟多余的数组空间
         * 题干规定了 nums[i]<=1000 >=1 ，因此使用低十位存原数值，高十位存新值，最后统一用高位替换低位
         */
        public int[] shuffle(int[] nums, int n) {
            for (int i = 0; i < 2 * n; i++) {
                // j表示当前nums[i]对应新下标
                int j = i < n ? 2 * i : 2 * (i - n) + 1;
                // 在j的高位存储nums[i]，低位存储原值
                nums[j] |= ((nums[i] & 1023) << 10);
            }
            // 使用高位替换低位
            for (int i = 0; i < 2 * n; i++) {
                nums[i] >>= 10;
            }
            return nums;
        }
    }
}
