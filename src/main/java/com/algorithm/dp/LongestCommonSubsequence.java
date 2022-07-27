package com.algorithm.dp;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 * <p>
 * https://leetcode.cn/problems/longest-common-subsequence/
 *
 * @author dragonsong  @date 2022/7/27
 */
public class LongestCommonSubsequence {

    /*
     * 执行用时：
     * 9 ms
     * , 在所有 Java 提交中击败了
     * 75.26%
     * 的用户
     * 内存消耗：
     * 45.7 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     * 通过测试用例：
     * 45 / 45
     */

    /**
     * |  LCS问题要素  |   |
     * |  ----  | ----  |
     * |  状态表示  | `dp[i][j]`表示`text1[0,i] text2[0,j]`两个字符串的LCS；  |
     * |  阶段划分  | 已处理的前缀串，对应矩阵 dp[i][j]；  |
     * |  转移方程  | dp[i][j]= Max(dp[i-1][j], dp[i][j-1], text1[i]==text2[j] ? dp[i-1][j-1]+1 : dp[i-1][j-1])  |
     * |  边界  | dp[-1][j]==dp[i][-1]==0，即任一字符串为空时，LCS公共子序列为空。 |
     * |  目标  | `dp[i][j]`，其中`i==text1.len-1 j=text2.len-1`  |
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        // 先初始化首行首列
        char text1First = text1.charAt(0);
        char text2First = text2.charAt(0);
        if (text1First == text2First) {
            // 两个串首字符相同时，LCS为1，表示有一个公共子序列，且最长
            dp[0][0] = 1;
        }
        // 首列，纵向一列的空间状态中，下一个状态只取决于上一行的状态。如果与 text1First 同，说明此处 dp[i][0]==1 ，否则与首列上一行状态一致。
        for (int j = 1; j < n; j++) {
            if (text1First == text2.charAt(j)) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // 首行，横向一行的空间状态中，下一个状态只取决于上一列的状态。如果与 text2First 同，说明此处 dp[0][j]==1 ，否则与首行上一列状态一致。
        for (int i = 1; i < m; i++) {
            if (text2First == text1.charAt(i)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // 在矩阵空间线性递推。当前 [i][j] 坐标状态，取决于当前字符是否匹配+同行上一列状态+同列上一行状态+左上角状态
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
