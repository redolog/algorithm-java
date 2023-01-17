package com.algorithm.dataStructure.array.app.count;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/count-nice-pairs-in-an-array/
 *
 * @author songhuilong  @date 2023/1/17
 */
public class CountNicePairsInAnArray {

    private static int rev(int num) {
        int revVal = 0;
        while (num > 0) {
            int quotient = num / 10;
            int remainder = num % 10;
            revVal = revVal * 10 + remainder;
            num = quotient;
        }
        return revVal;
    }

    static class BFSolution {
        /**
         * 时间：O(n^2)
         * 空间：O(n)
         */
        public int countNicePairs(int[] nums) {
            Map<Integer, Integer> num2Rev = new HashMap<>();
            for (int num : nums) {
                if (num2Rev.containsKey(num)) {
                    continue;
                }
                num2Rev.put(num, rev(num));
            }

            int n = nums.length, ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] + num2Rev.get(nums[j]) == nums[j] + num2Rev.get(nums[i])) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

    static class CntDPSolution {
        /**
         * n表示nums.len
         * c表示nums[i]数字大小
         * 时间：O(n+logC)
         * 空间：O(n)
         * <p>
         * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
         * 相当于 f(i) == f(j) == (nums[i]-rev(nums[i]))
         * 1. 维护 (nums[i]-rev(nums[i])) 出现次数
         * 2. 对>=2次的数对进行对数求和
         * 2.1 2次为1对；3次为3对（1+2）；4次为6对（3+3）；5次为10对（6+4）；
         * 2.2 总结规律：2次为1对，为对数初始情况，cnt次为 prev+cnt-1 对；
         * <p>
         * |   求和要素  |   |
         * |  ----  | ----  |
         * |  状态表示  | `dp[i]`表示值出现i次对应的数对；  |
         * |  阶段划分  | i+1为i的新阶段；  |
         * |  转移方程  | dp[2]=1; dp[i]=dp[i-1]+i-1； |
         * |  边界  | dp[2]=1 |
         * |  目标  | dp[i]  |
         * <p>
         * 可以得出，在计数时，同时可以维护 dp[i]。这里为了好理解，我将求和逻辑单独写到下面。
         *
         * <p>
         * 提示1：The condition can be rearranged to (nums[i] - rev(nums[i])) == (nums[j] - rev(nums[j])).
         * 提示2：Transform each nums[i] into (nums[i] - rev(nums[i])). Then, count the number of (i, j) pairs that have equal values.
         * 提示3：Keep a map storing the frequencies of values that you have seen so far. For each i, check if nums[i] is in the map. If it is, then add that count to the overall count. Then, increment the frequency of nums[i].
         */
        public int countNicePairs(int[] nums) {
            int mod = (int) 1e9 + 7;
            Map<Integer, Integer> val2Cnt = new HashMap<>();
            for (int num : nums) {
                int rev = rev(num), val = num - rev;
                val2Cnt.put(val, val2Cnt.getOrDefault(val, 0) + 1);
            }

            int ans = 0;
            int maxCnt = val2Cnt.values().stream().max(Integer::compareTo).orElse(0);
            if (maxCnt < 2) {
                return 0;
            }
            int[] dp = new int[maxCnt + 1];
            dp[2] = 1;
            for (int i = 3; i <= maxCnt; i++) {
                dp[i] = (dp[i - 1] + i - 1) % mod;
            }
            for (Integer cnt : val2Cnt.values()) {
                if (cnt == 1) {
                    continue;
                }
                // 出现次数cnt，和为 dp[cnt]
                ans = (ans + dp[cnt]) % mod;
            }
            return ans;
        }
    }
}
