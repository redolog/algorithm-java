package com.algorithm.dataStructure.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/count-items-matching-a-rule/
 *
 * @author DragonSong  @date 2022/10/29
 */
public class CountItemsMatchingARule {

    private static final Map<String, Integer> RULE_KEY2_ITEM_IDX = new HashMap<String, Integer>() {{
        put("type", 0);
        put("color", 1);
        put("name", 2);
    }};

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：常数空间开销，O(1)
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0, ruleIdx = RULE_KEY2_ITEM_IDX.get(ruleKey);
        for (List<String> item : items) {
            if (item.get(ruleIdx).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }
}
