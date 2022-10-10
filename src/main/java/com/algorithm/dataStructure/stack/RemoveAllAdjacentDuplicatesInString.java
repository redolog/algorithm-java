package com.algorithm.dataStructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 *
 * @author songhuilong  @date 2022/10/10
 */
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates2(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (builder.length() == 0) {
                builder.append(s.charAt(i));
                continue;
            }

            char top = builder.charAt(builder.length() - 1);
            if (s.charAt(i) == top) {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public String removeDuplicates(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        stk.offerLast(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (stk.isEmpty()) {
                stk.offerLast(s.charAt(i));
                continue;
            }

            char top = stk.peekLast();
            if (s.charAt(i) == top) {
                stk.pollLast();
            } else {
                stk.offerLast(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stk.isEmpty()) {
            builder.append(stk.pollFirst());
        }
        return builder.toString();
    }
}
