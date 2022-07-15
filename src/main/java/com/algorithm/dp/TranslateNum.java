package com.algorithm.dp;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 * <p>
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author dragonsong  @date 2022/7/15
 */
public class TranslateNum {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 22.76%
     * 的用户
     * 通过测试用例：
     * 49 / 49
     */

    /**
     * |   要素  |   |
     * |  ----  | ----  |
     * |  状态表示  | `dp[i]`表示以`numArr[i]`结尾可能的翻译数；  |
     * |  阶段划分  | 子序列结尾；  |
     * |  转移方程  | `dp[i]=dp[i-1] + Valid(numArr,i-1,i) ? dp[i-2] : 0`，0<=i<=n-1，其中`Valid`验证两位数是否在 [0,25] 范围内，如果不在，则两位数字方案为0；  |
     * |  边界  | dp[0]只有一位数字，dp[0]=1，dp[1]=1+Valid(numArr[0,1]) |
     * |  目标  | `dp[n-1] (0<=i<=n-1)`  |
     */
    public int translateNum(int num) {
        if (num / 10 == 0) {
            return 1;
        }
        char[] numArr = String.valueOf(num).toCharArray();
        int n = numArr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = dp[0] + (valid(numArr, 0, 1) ? 1 : 0);
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + (valid(numArr, i - 1, i) ? dp[i - 2] : 0);
        }
        return dp[n - 1];
    }

    private boolean valid(char[] numArr, int startInclusive, int endInclusive) {
        // 十位
        int tenBit = numArr[startInclusive] - '0';
        int num = 10 * tenBit + numArr[endInclusive] - '0';
        if (tenBit != 0 && num >= 0 && num <= 25) {
            // 二位数合法，方案数=1位的+2位的
            return true;
        }
        // 只有1位的方案数
        return false;
    }
}
