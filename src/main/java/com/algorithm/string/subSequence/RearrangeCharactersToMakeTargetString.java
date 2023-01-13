package com.algorithm.string.subSequence;

import java.util.Comparator;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 *
 * @author songhuilong  @date 2023/1/13
 */
public class RearrangeCharactersToMakeTargetString {

    static class ArrCountSolution {
        public int rearrangeCharacters(String s, String target) {
            // 对s、target中的letter计数
            int[] targetCharCnt = new int[26], sCharCnt = new int[26];
            int targetN = target.length(), sN = s.length();
            for (int i = 0; i < targetN; i++) {
                targetCharCnt[target.charAt(i) - 'a']++;
            }
            for (int i = 0; i < sN; i++) {
                sCharCnt[s.charAt(i) - 'a']++;
            }
            // s中字母数按target分组计数，ans取组最小数
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (targetCharCnt[i] == 0) {
                    continue;
                }
                sCharCnt[i] = sCharCnt[i] / targetCharCnt[i];
                ans = Math.min(ans, sCharCnt[i]);
            }
            return ans;
        }
    }

    static class StreamSolution {
        public int rearrangeCharacters(String s, String target) {
            Map<Character, Long> sourceC2Cnt = s.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Character, Long> targetC2Cnt = target.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            return targetC2Cnt.keySet()
                    .stream()
                    .reduce(
                            Long.MAX_VALUE,
                            (acc, c) -> Math.min(acc, sourceC2Cnt.getOrDefault(c, 0L) / targetC2Cnt.get(c)),
                            BinaryOperator.minBy(Comparator.naturalOrder())
                    )
                    .intValue();
        }
    }
}
