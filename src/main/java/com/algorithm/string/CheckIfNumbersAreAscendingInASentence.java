package com.algorithm.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 *
 * @author songhuilong  @date 2023/1/3
 */
public class CheckIfNumbersAreAscendingInASentence {

    static class LoopSolution {
        /**
         * 时间：O(n)
         * 空间：O(1)
         */
        public boolean areNumbersAscending(String s) {
            int n = s.length(), prev = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) {
                    continue;
                }
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                if (prev >= num) {
                    return false;
                }
                prev = num;
            }
            return true;
        }
    }

    static class StreamSolution {
        /**
         * 时间：O(n)
         * 空间：O(n)
         */
        public boolean areNumbersAscending(String s) {
            List<Integer> numList = Arrays.stream(s.split(" "))
                    .filter(this::isNumber)
                    .map(this::str2Number)
                    .collect(Collectors.toList());
            return IntStream.range(1, numList.size())
                    .noneMatch(secondIdx -> numList.get(secondIdx - 1) >= numList.get(secondIdx));
        }

        private int str2Number(String str) {
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                num = num * 10 + str.charAt(i) - '0';
            }
            return num;
        }

        private boolean isNumber(String str) {
            if (isEmpty(str)) {
                return false;
            }
            if (str.length() == 1) {
                return isDigit(str.charAt(0));
            }
            if (str.charAt(0) == '0') {
                return false;
            }
            for (int i = 1; i < str.length(); i++) {
                if (!isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        private boolean isDigit(char c) {
            return c >= '0' && c <= '9';
        }

        private boolean isEmpty(String str) {
            return null == str || str.length() == 0;
        }
    }
}
