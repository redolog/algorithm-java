package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/rotated-digits/
 *
 * @author DragonSong  @date 2022/9/25
 */
public class RotatedDigits {

    /**
     * [1,n]逐个数字判断是否为好数，计数
     *
     * 时间复杂度：O(n*logn)
     */
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (goodNum(num)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 逐位检查每位：
     * - 0 1 8 跳过，因为翻转后一致
     * - 2 5 6 9 翻转后有效
     * - 3 4 7 翻转后数字失效
     * <p>
     * 好数：如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
     */
    private boolean goodNum(int num) {
        boolean exist2569 = false;
        while (num != 0) {
            int originalDigit = num % 10;
            num = num / 10;
            if (originalDigit == 3 || originalDigit == 4 || originalDigit == 7) {
                return false;
            }
            if (originalDigit == 0 || originalDigit == 1 || originalDigit == 8) {
                continue;
            }
            if (originalDigit == 2 || originalDigit == 5 || originalDigit == 6 || originalDigit == 9) {
                exist2569 = true;
            }
        }
        return exist2569;
    }
}
