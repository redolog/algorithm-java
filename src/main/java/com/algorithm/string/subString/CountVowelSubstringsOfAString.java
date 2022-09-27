package com.algorithm.string.subString;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/count-vowel-substrings-of-a-string/
 *
 * @author songhuilong  @date 2022/9/27
 */
public class CountVowelSubstringsOfAString {

    static class SetSolution {
        /**
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         */
        public int countVowelSubstrings(String word) {
            Set<Character> vowelSet = new HashSet<Character>() {{
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
            }};
            int n = word.length(), ans = 0;
            for (int i = 0; i < n; i++) {
                // i 开头的子串
                Set<Character> substringSet = new HashSet<>();
                for (int j = i; j < n; j++) {
                    char curr = word.charAt(j);
                    if (!vowelSet.contains(curr)) {
                        break;
                    }
                    substringSet.add(curr);
                    if (substringSet.size() == 5) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
