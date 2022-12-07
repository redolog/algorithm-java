package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/summary-ranges/
 *
 * @author songhuilong001  @date 2022/12/7
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(nums[i]);
            int segStart = i;
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (i != segStart) {
                builder.append("->").append(nums[i]);
            }
            ans.add(builder.toString());
        }
        return ans;
    }
}
