package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/strong-password-checker-ii/
 *
 * @author songhuilong001  @date 2023/1/19
 */
public class StrongPasswordCheckerII {

    public static final String SPECIAL_STR = "!@#$%^&*()-+";

    public boolean strongPasswordCheckerII(String password) {
        // String 入参需满足的规则
        List<Predicate<String>> stringAndRules = new ArrayList<>();
        stringAndRules.add(lengthGte8Predicate());
        // String 入参逐个字符reduce满足的规则
        List<Predicate<Integer>> stringReduceRules = new ArrayList<>();
        stringReduceRules.add(continuousNotEqualsPredicate(password));
        // 任一char满足即可的规则
        List<Predicate<Character>> charAnyAndRules = new ArrayList<>();
        charAnyAndRules.add(lowerCaseLetterPredicate());
        charAnyAndRules.add(upperCaseLetterPredicate());
        charAnyAndRules.add(digitLetterPredicate());
        charAnyAndRules.add(specialLetterPredicate());

        // pwd需满足的所有规则
        if (!stringAndRules.stream().allMatch(stringPredicate -> stringPredicate.test(password))) {
            return false;
        }
        // pwd reduce连续字符需满足的所有规则
        for (int i = 0; i < password.length() - 1; i++) {
            int finalI = i;
            if (!stringReduceRules.stream().allMatch(integerPredicate -> integerPredicate.test(finalI))) {
                return false;
            }
        }
        // pwd 整串只要有一个单字符满足即满足对应规则：整串下有单字符不满足即可fail-fast
        for (Predicate<Character> predicate : charAnyAndRules) {
            if (IntStream.range(0, password.length()).noneMatch(i -> predicate.test(password.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private Predicate<Integer> continuousNotEqualsPredicate(String password) {
        return i -> password.charAt(i) != password.charAt(i + 1);
    }

    private Predicate<String> lengthGte8Predicate() {
        return s -> s != null && s.length() >= 8;
    }

    private Predicate<Character> lowerCaseLetterPredicate() {
        return c -> c >= 'a' && c <= 'z';
    }

    private Predicate<Character> upperCaseLetterPredicate() {
        return c -> c >= 'A' && c <= 'Z';
    }

    private Predicate<Character> digitLetterPredicate() {
        return c -> c >= '0' && c <= '9';
    }

    private Predicate<Character> specialLetterPredicate() {
        return c -> SPECIAL_STR.contains(String.valueOf(c));
    }
}
