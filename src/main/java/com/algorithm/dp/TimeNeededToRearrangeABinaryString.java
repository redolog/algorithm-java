package com.algorithm.dp;

/**
 * 给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。
 * <p>
 * 请你返回完成这个过程所需要的秒数。
 *
 * @author dragonsong  @date 2022/8/20
 */
public class TimeNeededToRearrangeABinaryString {

    static class BF {
        public int secondsToRemoveOccurrences(String s) {
            int ans = 0;
            while (s.contains("01")) {
                s = s.replaceAll("01", "10");
                ans++;
            }
            return ans;
        }
    }

    static class DP {
        /**
         * |   要素  |   |
         * |  ----  | ----  |
         * |  状态表示  | `dp[i]`表示将 `s[i]` 处的1挪动到最左侧最少需要的秒数；`pre0`表示当前位置前序0个数；  |
         * |  阶段划分  | 每个1出现均为新的阶段，0维持与前序相同的状态值；  |
         * |  转移方程  | `s[i]=='0'时，dp[i]=dp[i-1]` ;`s[i]=='1'并且pre0!=0时，dp[i]= max(dp[i-1]+1,pre0)`，dp[i-1]+1 表示1前序为1，需要多一次移动； |
         * |  边界  | dp[0]=0； |
         * |  目标  | max(dp[i])  |
         */
        public int secondsToRemoveOccurrences(String s) {
            int[] dp = new int[s.length()];
            dp[0] = 0;
            int ans = 0;
            int pre0 = s.charAt(0) == '0' ? 1 : 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    dp[i] = dp[i - 1];
                    pre0++;
                    continue;
                }
                // s[i]=='1'
                // 前序有0才能移动后序的1
                if (pre0 == 0) {
                    continue;
                }
                dp[i] = Math.max(dp[i - 1] + 1, pre0);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }

        /**
         * 简化版本：只维护前序值，滚动数组
         */
        public int secondsToRemoveOccurrences2(String s) {
            // 状态压缩，我们只记录前序dp状态即可
            int dpPrev = 0, pre0 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    pre0++;
                    continue;
                }
                // s[i]=='1'
                // 前序有0才能移动后序的1
                if (pre0 == 0) {
                    continue;
                }
                dpPrev = Math.max(dpPrev + 1, pre0);
            }
            return dpPrev;
        }

        public int secondsToRemoveOccurrences3(String s) {
            int n = s.length();
            int pre0 = 0;
            int[] dp = new int[n];
            // i寻找下一个1，j存储dp状态
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    pre0++;
                    if (i != 0) {
                        dp[i] = dp[i - 1];
                    }
                    continue;
                }
                // s[i]=='1'
                if (pre0 == 0) {
                    // 前序没0，说明目前为止的1都不需要挪动，状态为0
                    dp[i] = 0;
                    continue;
                }
                dp[i] = Math.max(dp[i - 1] + 1, pre0);
                ans = Math.max(dp[i], ans);
            }
            return ans;
        }
    }


}
