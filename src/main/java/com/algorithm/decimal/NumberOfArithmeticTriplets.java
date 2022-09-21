package com.algorithm.decimal;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/number-of-arithmetic-triplets/
 *
 * @author songhuilong  @date 2022/9/21
 */
public class NumberOfArithmeticTriplets {

    static class SetSolution {
        /**
         * 使用set存储每个数字，遍历到三元组的第三项时，判断前两项是否存在即可
         */
        public int arithmeticTriplets(int[] nums, int diff) {
            Set<Integer> set = new HashSet<>();
            int ans = 0;
            for (int num : nums) {
                set.add(num);
                if (set.contains(num - diff) && set.contains(num - diff * 2)) {
                    ans++;
                }
            }
            return ans;
        }
    }

    static class TriplePointerSolution {
        /**
         * 使用三个指针分别表示一个算术三元组的三个元素
         * 空间复杂度可降为 O(1)
         */
        public int arithmeticTriplets(int[] nums, int diff) {
            int ans = 0;
            // abc分别表示三个元素位置
            int a, b = 1, c, n = nums.length;
            for (int i = 0; i < n; i++) {
                a = i;
                // b一直挪动到本组最右
                while (b < n - 1 && nums[b + 1] - nums[a] <= diff) {
                    b++;
                }
                // c一直挪动到本组最右
                c = b + 1;
                while (c < n - 1 && nums[c + 1] - nums[b] <= diff) {
                    c++;
                }
                if (c < n && nums[b] - nums[a] == diff && nums[c] - nums[b] == diff) {
                    ans++;
                }
            }
            return ans;
        }
    }


}
