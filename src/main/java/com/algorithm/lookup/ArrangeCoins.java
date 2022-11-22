package com.algorithm.lookup;

/**
 * https://leetcode.cn/problems/arranging-coins/
 *
 * @author songhuilong001  @date 2022/11/22
 */
public class ArrangeCoins {
    /**
     * Sn=n(a1+an)/2 注：n为正整数
     */
    public int arrangeCoins(int n) {
        // [l,r] 表示第几行
        int l = 1, r = n;
        while (l <= r) {
            // 取中点靠右一点，防止mid一直等于l（用例输入2）
            int mid = l + ((r - l + 1) >> 1);
            // 必须转long，不然会溢出，等差数列和 / 2
            long sum = (long) mid * (1 + mid);
            if (sum == n * 2L) {
                return mid;
            } else if (sum < n * 2L) {
                l = mid;
            } else {
                if (mid - 1 == 1 || (long) mid * (mid - 1) <= n * 2L) {
                    return mid - 1;
                }
                r = mid;
            }
        }
        return l;
    }

}
