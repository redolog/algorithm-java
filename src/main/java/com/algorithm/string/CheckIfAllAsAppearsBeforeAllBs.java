package com.algorithm.string;

/**
 * https://leetcode.cn/problems/check-if-all-as-appears-before-all-bs/
 *
 * @author songhuilong  @date 2022/11/3
 */
public class CheckIfAllAsAppearsBeforeAllBs {

    static class TwoPointerSolution {
        public boolean checkString(String s) {
            int prev = 0, curr = 1, n = s.length();
            while (curr < n) {
                if (s.charAt(prev) > s.charAt(curr)) {
                    return false;
                }
                curr++;
                prev++;
            }
            return true;
        }
    }
}
