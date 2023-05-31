package com.algorithm.string.subString;


/**
 * <a href="https://leetcode.cn/problems/remove-trailing-zeros-from-a-string/">2710. Remove Trailing Zeros From a String</a>
 *
 * @author songhuilong  @date 2023/5/31
 */
public class RemoveTrailingZerosFromAString {

    public String removeTrailingZeros(String num) {
        int n = num.length(), tailIdx = n;
        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                tailIdx = i;
            } else {
                break;
            }
        }
        return num.substring(0, tailIdx);
    }
}
