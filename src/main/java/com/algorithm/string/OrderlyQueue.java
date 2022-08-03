package com.algorithm.string;

import java.util.Arrays;

/**
 * 899. 有序队列
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * <p>
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 * <p>
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= S.length <= 1000
 * s 只由小写字母组成。
 * <p>
 * https://leetcode.cn/problems/orderly-queue/
 *
 * @author dragonsong  @date 2022/8/3
 */
public class OrderlyQueue {

    /*
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 93.84%
     * 的用户
     * 内存消耗：
     * 41.1 MB
     * , 在所有 Java 提交中击败了
     * 83.41%
     * 的用户
     * 通过测试用例：
     * 110 / 110
     */

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            // k>1 时，通过无限次转换，总能转成严格字典序的字符序列
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        // k==1 时，只能把第一个字符放最后
        String ans = s;
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char firstChar = builder.charAt(0);
            builder.deleteCharAt(0);
            builder.append(firstChar);
            if (builder.toString().compareTo(ans) < 0) {
                ans = builder.toString();
            }
        }
        return ans;
    }
}
