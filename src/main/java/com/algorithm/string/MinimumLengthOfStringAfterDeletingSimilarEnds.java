package com.algorithm.string;

/**
 * https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/
 *
 * @author songhuilong  @date 2022/12/28
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public int minimumLength(String s) {
        int n = s.length(), l = 0, r = n - 1;
        while (l < r) {
            char lStart = s.charAt(l), rEnd = s.charAt(r);
            if (lStart != rEnd) {
                break;
            }
            while (l + 1 < r && s.charAt(l + 1) == lStart) {
                l++;
            }
            while (r - 1 > l && s.charAt(r - 1) == rEnd) {
                r--;
            }
            l++;
            r--;
        }
        return r - l + 1;
    }
}
