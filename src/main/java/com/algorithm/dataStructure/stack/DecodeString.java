package com.algorithm.dataStructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/decode-string/
 *
 * @author songhuilong  @date 2025/11/9
 */
public class DecodeString {
    
    // 核心思想：
    // 以左右括号为一组的边界，遇到右括号之前，数字与字母入栈，遇到右括号之后，开始从栈取出前序元素处理

    public String decodeString(String s) {
        // 数字判定：c-'0' >=0 && c-'0' <=9
        // 字母判定：c-'a' >=0 && c-'a' <26 
        // 括号判定：c == '[' || c == ']'
        char[] charArr = s.toCharArray();
        int n = charArr.length;
        // 算法概述：
        // 数字，入栈，等待当前组后续右括号遍历完之后构建当前组字符串
        // 左括号，入栈
        // 字母，入栈
        // 右括号，触发一次出栈，将栈顶的字母出栈 + 数字出栈，拼接后再次入栈
        // 最后将栈中遗留字符串依次出栈，拼接可得答案

        Deque<String> stk = new ArrayDeque<>();

        for (int i = 0; i < n; ) {

            if (checkDigit(charArr[i])) {
                // 数字
                StringBuilder digit = new StringBuilder();
                while (i < n && checkDigit(charArr[i])) {
                    digit.append(charArr[i++]);
                }
                stk.offerLast(digit.toString());
            } else if (checkLetter(charArr[i])) {
                // 字母
                StringBuilder letter = new StringBuilder();
                while (i < n && checkLetter(charArr[i])) {
                    letter.append(charArr[i++]);
                }
                stk.offerLast(letter.toString());
            } else if (charArr[i] == '[') {
                // 左括号
//                stk.offerLast("" + charArr[i++]);
                i++;
            } else if (charArr[i] == ']') {
                // 右括号

                // 字母出栈
                List<String> letterList = new LinkedList<>();
                while (!stk.isEmpty() && checkLetter(stk.peekLast().charAt(0))) {
                    letterList.add(stk.pollLast());
                }
                StringBuilder letter = new StringBuilder();
                for (int i1 = letterList.size() - 1; i1 >= 0; i1--) {
                    letter.append(letterList.get(i1));
                }
                // 数字
                String digit = stk.pollLast();
                Integer digitInt = Integer.parseInt(digit);
                StringBuilder words = new StringBuilder();
                while (digitInt > 0) {
                    words.append(letter);
                    digitInt--;
                }
                // 将前序已入栈的字母取出，与当前子段字母拼接
                stk.offerLast(words.toString());
                i++;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stk.isEmpty()) {
            ans.append(stk.pollFirst());
        }
        return ans.toString();
    }

    private boolean checkDigit(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }

    private boolean checkLetter(char c) {
        return c - 'a' >= 0 && c - 'a' < 26;
    }

}
