package com.algorithm.string;

/**
 * https://leetcode.cn/problems/final-value-of-variable-after-performing-operations/
 *
 * @author songhuilong  @date 2022/12/23
 */
public class FindValueOfVariableAfterPerformingOperations {

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }
}
