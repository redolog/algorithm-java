package com.algorithm.string;

/**
 * https://leetcode.cn/problems/delete-characters-to-make-fancy-string/
 *
 * @author songhuilong  @date 2022/11/4
 */
public class DeleteCharactersToMakeFancyString {

    public String makeFancyString(String s) {
        int n = s.length();
        if (n < 3) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) || s.charAt(i) != s.charAt(i + 2)) {
                builder.append(s.charAt(i));
            }
        }
        builder.append(s.charAt(n - 2)).append(s.charAt(n - 1));
        return builder.toString();
    }
}
