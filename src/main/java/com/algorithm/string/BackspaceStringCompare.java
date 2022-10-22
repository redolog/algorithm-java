package com.algorithm.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/backspace-string-compare/
 *
 * @author DragonSong  @date 2022/10/22
 */
public class BackspaceStringCompare {

    static class StackSolution {
        public boolean backspaceCompare(String s, String t) {
            return transWithBuilder(s).equals(transWithBuilder(t));
        }

        private String transWithStack(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            Deque<Character> stk = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '#') {
                    if (!stk.isEmpty()) {
                        stk.pollLast();
                    }
                } else {
                    stk.offerLast(c);
                }
            }

            StringBuilder builder = new StringBuilder();
            for (char c : stk) {
                builder.append(c);
            }
            return builder.toString();
        }

        private String transWithBuilder(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '#') {
                    if (builder.length() > 0) {
                        builder.deleteCharAt(builder.length() - 1);
                    }
                } else {
                    builder.append(c);
                }
            }
            return builder.toString();
        }
    }
}
