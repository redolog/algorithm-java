package com.algorithm.dataStructure.array.subSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-harmonious-subsequence/
 *
 * @author songhuilong  @date 2022/11/15
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> num2Cnt = new HashMap<>();
        for (int num : nums) {
            num2Cnt.merge(num, 1, Integer::sum);
        }
        int ans = 0;
        for (Integer num : num2Cnt.keySet()) {
            if (num2Cnt.containsKey(num + 1)) {
                ans = Math.max(ans, num2Cnt.get(num) + num2Cnt.get(num + 1));
            }
        }
        return ans;
    }
}
