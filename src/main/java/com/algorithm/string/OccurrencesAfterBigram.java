package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/occurrences-after-bigram/
 *
 * @author songhuilong  @date 2022/10/11
 */
public class OccurrencesAfterBigram {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String[] textArr = text.split(" ");
        for (int i = 0; i < textArr.length - 2; i++) {
            if (first.equals(textArr[i]) && second.equals(textArr[i + 1])) {
                ans.add(textArr[i + 2]);
            }
        }
        return ans.toArray(new String[0]);
    }
}
