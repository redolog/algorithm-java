package com.algorithm.decimal;


/**
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * <p>
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * 示例 2：
 * <p>
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 * 通过次数55,046提交次数98,978
 * <p>
 * https://leetcode.cn/problems/convert-a-number-to-hexadecimal/
 *
 * @author dragonsong  @date 2022/7/10
 */
public class ConvertANumber2Hexadecimal {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 80.36%
     * 的用户
     * 通过测试用例：
     * 100 / 100
     */

    /**
     * 二进制中数字的表示：使用32个二进制位，第一位表示正负，其余位表示数值
     * <p>
     * 负数取反+1后，恰好为其相反正数的表示
     * int32 取值范围：[−2^31,2^31−1]
     * <p>
     * 在十六进制中，
     * [0, 2^{31} - 1][0,2^31−1] 范围内的数对应的十六进制存储方式为 00000000-7fffffff，
     * [-2^31,-1][−2^31−1] 范围内的数对应的十六进制存储方式为 80000000-ffffffff
     * <p>
     * 因此对于入参num，我们判断如果是负数，则将其转换到 long64位的空间中，所有32位int负数，+2^32 后，结果正好处于：[2^31,2^32-1]
     * 对于此时的每一个int64正数，我们映射到base16的字符串表示上即可
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        String base16 = "0123456789abcdef";
        long numLong = num < 0 ? (long) num + (1L << 32) : num;

        StringBuilder builder = new StringBuilder();
        while (numLong > 0) {
            long quotient = numLong / 16;
            long remainder = numLong % 16;
            builder.insert(0, base16.charAt((int) remainder));
            numLong = quotient;
        }
        return builder.toString();
    }
}
