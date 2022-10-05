package com.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-case-permutation/
 *
 * @author DragonSong  @date 2022/10/6
 */
public class LetterCasePermutation {

    List<String> ans;

    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        dfs(s.toCharArray(), 0);
        return ans;
    }

    private void dfs(char[] chars, int idx) {
        ans.add(String.valueOf(chars));

        for (int i = idx; i < chars.length; i++) {
            // 数字位，直接跳过
            char currC = chars[i];
            if (isNotLetter(currC)) {
                continue;
            }
            chars[i] = transformCase(chars[i]);
            dfs(chars, i + 1);
            chars[i] = currC;
        }
    }

    private boolean isNotLetter(char c) {
        return !isLowerLetter(c) && !isUpperLetter(c);
    }

    private boolean isLowerLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isUpperLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private char toUpper(char c) {
        return (char) (c - 32);
    }

    private char toLower(char c) {
        return (char) (c + 32);
    }

    private char transformCase(char c) {
        return isLowerLetter(c) ? toUpper(c) : toLower(c);
    }

}
