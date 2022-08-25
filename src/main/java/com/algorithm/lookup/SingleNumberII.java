package com.algorithm.lookup;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/single-number-ii/
 *
 * @author dragonsong  @date 2022/8/25
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> num2Once = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // true 表示只出现了一次
            if (num2Once.containsKey(num)) {
                num2Once.put(num, false);
            } else {
                num2Once.put(num, true);
            }
        }
        return num2Once.entrySet().stream().filter(Map.Entry::getValue).findAny().get().getKey();
    }
}
