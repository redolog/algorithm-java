package com.algorithm.string;

import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/circular-sentence/
 *
 * @author songhuilong001  @date 2022/12/12
 */
public class CircularSentence {

    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        for (int i = 1; i < n - 1; i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                return false;
            }
        }
        return sentence.charAt(0) == sentence.charAt(n - 1);
    }

    static class StreamSolution {
        public boolean isCircularSentence(String sentence) {
            int n = sentence.length();
            return IntStream.rangeClosed(1, n - 2)
                    .noneMatch(i -> sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1))
                    && sentence.charAt(0) == sentence.charAt(n - 1);
        }
    }
}
