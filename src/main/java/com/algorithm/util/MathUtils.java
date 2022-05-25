package com.algorithm.util;

/**
 * copied from https://www.changgy.com/leetcode-101
 */
public class MathUtils {

    private MathUtils() {
    }

    public static int abs(int a) {
        return a < 0 ? ~a + 1 : a;
    }

    /**
     * 1.求整数商： c = [a/b];
     * 2.计算模或者余数： r = a - c*b.
     * <p>
     * 第一步：求整数商c：
     * ①进行求模运算c = [a/b] = -7 / 4 = -2（向负无穷方向舍入），
     * ②进行求余运算c = [a/b] = -7 / 4 = -1（向0方向舍入）；
     * 第二步：计算模和余数的公式相同，但因c的值不同，
     * ①求模时：r = a - c*b =-7 - (-2)*4 = 1，
     * ②求余时：r = a - c*b = -7 - (-1)*4 =-3。
     *
     * @return a mod b
     */
    public static int mod(int a, int b) {
        // floorDiv 取模运算在计算c的值时，向负无穷方向舍入(floor()函数)
        return a - Math.floorDiv(a, b) * b;
    }

    /**
     * 利用辗转相除法，求得两个数的最大公因数(greatest common divisor，gcd);
     * <p>
     * dividend / divisor
     * 被除数 / 除数
     * non-zero integers 非零整数
     *
     * @param dividend dividend 被除数
     * @param divisor  divisor 除数
     * @return 最大公约数
     */
    public static int gcd(int dividend, int divisor) {
        return divisor == 0
                ? dividend
                // https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/1647675?fromtitle=%E8%BE%97%E8%BD%AC%E7%9B%B8%E9%99%A4%E6%B3%95&fromid=4625352
                // 计算公式gcd(a,b) = gcd(b,a mod b)。
                : gcd(divisor, dividend % divisor);
    }

    /**
     * 将两个数相乘再除以最大公因数即可得到最小公倍数(least common multiple, lcm)
     * https://baike.baidu.com/item/%E6%9C%80%E5%B0%8F%E5%85%AC%E5%80%8D%E6%95%B0
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return least common multiple, lcm 最小公倍数
     */
    public static int lcm(int dividend, int divisor) {
        return dividend * divisor / gcd(dividend, divisor);
    }


    /**
     * 进一步地，我们也可以通过扩展欧几里得算法(extended gcd)在求得 a 和 b 最大公因数的同 时，也得到它们的系数 x 和 y，从而使 ax + by = gcd(a, b)。
     * https://baike.baidu.com/item/%E6%89%A9%E5%B1%95%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/2029414
     * 扩展欧几里得算法
     */
    static class GCDExtend {
        public int extendGCD(int a, int b) {
            if (b == 0) {
                x = 1;
                y = 0;
                return a;
            }
            int gcd = extendGCD(b, a % b);
            swapXY();  //x y进行互换以保证公式在迭代时是正确的
            y -= a / b * x;
            return gcd;
        }

        void swapXY() {
            int tem = x;
            x = y;
            y = tem;
        }

        public int x;
        public int y;
    }
}