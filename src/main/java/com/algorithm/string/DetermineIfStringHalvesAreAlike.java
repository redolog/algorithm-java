package com.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/determine-if-string-halves-are-alike/
 *
 * @author songhuilong  @date 2022/9/14
 */
public class DetermineIfStringHalvesAreAlike {

    // 'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'
    Set<Character> set = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        return cnt(s.substring(0, n / 2)) == cnt(s.substring(n / 2));
    }

    private int cnt(String str) {
        int ans = 0;
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                ans++;
            }
        }
        return ans;
    }
}
