package com.algorithm.decimal;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * https://leetcode.cn/problems/add-binary/
 *
 * @author dragonsong  @date 2022/8/3
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;

        // 进位
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int aNum = i < 0 ? 0 : a.charAt(i) - '0';
            int bNum = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = aNum + bNum + carry;

            ans.insert(0, sum >= 2 ? sum % 2 : sum);
            carry = sum >= 2 ? sum / 2 : 0;
            i--;
            j--;
        }

        return ans.toString();
    }
}
