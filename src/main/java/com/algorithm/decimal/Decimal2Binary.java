package com.algorithm.decimal;

/**
 * 十进制数字转二进制
 *
 * @author dragonsong  @date 2022/6/6
 */
public class Decimal2Binary {

    /**
     * 十进制转二进制过程：
     * num / 2 ，保留余数remainder
     * <p>
     * dividend 被除数 / divisor 除数 = quotient 商
     * <p>
     * 比如十进制5，
     * 5/2 余数1 商2
     * 2/2 余数0 商1
     * 1/2 余数1 商0
     * <p>
     * 当商为0时，除不动了，过程终止。
     * <p>
     * 因此，我们用递归的思路考虑：
     * 1. 边界：商为0。
     * 2. 递推公式：f(n)=f(n-1)+余数
     * 其中 f(n-1)=除法过程，获得商
     *
     * @param decimal 十进制数
     * @param ans     存结果的字符串结构
     */
    public static String decimal2BinaryStr(int decimal, String ans) {
        if (decimal == 0) {
            return "0" + ans;
        }
        int quotient = decimal / 2;
        int remainder = decimal % 2;
        ans = remainder + ans;
        return decimal2BinaryStr(quotient, ans);
    }
}
