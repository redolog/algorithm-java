package com.algorithm.dataStructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/set-mismatch/
 *
 * @author songhuilong001  @date 2022/11/21
 */
public class SetMismatch {

    /**
     * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     */
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> num2Cnt = new HashMap<>();
        for (int num : nums) {
            num2Cnt.merge(num, 1, Integer::sum);
        }
        int[] ans = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            Integer cnt = num2Cnt.getOrDefault(i, 0);
            if (cnt == 0) {
                ans[1] = i;
            }
            if (cnt == 2) {
                ans[0] = i;
            }
        }
        return ans;
    }
}
