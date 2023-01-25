package com.algorithm.string;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/number-of-valid-words-in-a-sentence/
 *
 * @author songhuilong001  @date 2023/1/25
 */
public class NumberOfValidWordsInASentence {

    public int countValidWords(String sentence) {
        return (int) Arrays.stream(sentence.split(" "))
                .filter(this::valid)
                .count();
    }

    private boolean valid(String word) {
        if (empty(word)) {
            return false;
        }
        int n = word.length(), enDashCnt = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (invalidChar(c)) {
                return false;
            }
            if (enDash(c)) {
                enDashCnt++;
                if (enDashCnt > 1) {
                    return false;
                }
                if (i - 1 < 0 || i + 1 > n - 1 || !lowerCaseLetter(word.charAt(i - 1)) || !lowerCaseLetter(word.charAt(i + 1))) {
                    return false;
                }
            }
            if (punctuation(c) && i != n - 1) {
                return false;
            }
        }
        return true;
    }

    private boolean empty(String s) {
        return s == null || s.length() == 0;
    }

    private boolean lowerCaseLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean enDash(char c) {
        return c == '-';
    }

    private boolean punctuation(char c) {
        return c == '!' || c == '.' || c == ',';
    }

    private boolean validChar(char c) {
        return lowerCaseLetter(c) || enDash(c) || punctuation(c);
    }

    private boolean invalidChar(char c) {
        return !validChar(c);
    }
}
