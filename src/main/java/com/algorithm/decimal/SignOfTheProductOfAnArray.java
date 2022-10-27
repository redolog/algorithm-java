package com.algorithm.decimal;

/**
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 *
 * @author songhuilong  @date 2022/10/27
 */
public class SignOfTheProductOfAnArray {

    /**
     * 时间：O(n)
     * 空间：O(1)
     */
    public int arraySign(int[] nums) {
        int product = 1;
        for (int num : nums) {
            product *= num;
            if (product == 0) {
                return 0;
            }
            product = product > 0 ? 1 : -1;
        }
        return product;
    }

}
