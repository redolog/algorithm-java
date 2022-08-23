package com.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-common-characters/
 *
 * @author dragonsong  @date 2022/8/23
 */
public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        int[] alphabetCntTable = new int[26];
        Arrays.fill(alphabetCntTable, Integer.MAX_VALUE);
        for (String word : words) {
            int[] thisWordAlpha = new int[26];
            for (char c : word.toCharArray()) {
                thisWordAlpha[c - 'a'] = thisWordAlpha[c - 'a'] + 1;
            }

            for (int i = 0; i < 26; i++) {
                alphabetCntTable[i] = Math.min(thisWordAlpha[i], alphabetCntTable[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (alphabetCntTable[i] >= 1) {
                ans.add(String.valueOf((char) (i + 'a')));
                alphabetCntTable[i] -= 1;
            }
        }
        return ans;
    }
}
