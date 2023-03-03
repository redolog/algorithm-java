package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/making-file-names-unique/
 *
 * @author songhuilong  @date 2023/3/3
 */
public class MakeFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        // k 是能保证文件名唯一的 最小正整数
        Map<String, Integer> prefix2K = new HashMap<>();
        int n = names.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String currPrefix = names[i];
            if (prefix2K.containsKey(currPrefix)) {
                Integer k = prefix2K.get(currPrefix);
                String name = buildName(currPrefix, k);
                // k需要一直叠加到不存在的name为之
                while (prefix2K.containsKey(name)) {
                    // 当前name已存在，k叠加
                    k++;
                    name = buildName(currPrefix, k);
                }
                String finalName = buildName(currPrefix, k);
                ans[i] = finalName;
                prefix2K.put(currPrefix, k + 1);
                prefix2K.put(finalName, 1);
            } else {
                ans[i] = currPrefix;
                prefix2K.put(currPrefix, 1);
            }
        }
        return ans;
    }

    private String buildName(String currPrefix, Integer k) {
        return currPrefix + "(" + k + ")";
    }
}
