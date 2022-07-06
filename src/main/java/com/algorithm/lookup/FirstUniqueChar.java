package com.algorithm.lookup;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * <p>
 * 输入：s = ""
 * 输出：' '
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * @author dragonsong  @date 2022/7/6
 */
public class FirstUniqueChar {

    /*
     * 执行用时：
     * 24 ms
     * , 在所有 Java 提交中击败了
     * 42.46%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 61.37%
     * 的用户
     * 通过测试用例：
     * 105 / 105
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> char2Cnt = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            char2Cnt.put(c, char2Cnt.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : char2Cnt.entrySet()) {
            Character c = entry.getKey();
            Integer cnt = entry.getValue();
            if (cnt == 1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 执行用时：
     * 20 ms
     * , 在所有 Java 提交中击败了
     * 66.48%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 59.52%
     * 的用户
     * 通过测试用例：
     * 105 / 105
     * <p>
     * 使用Boolean VAL 更省空间，同时利用了字符数组本身有序的特性
     * 相比较双向链表空间开销更小
     */
    public char firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        // 单次为true，多次为false
        Map<Character, Boolean> char2Once = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (char2Once.containsKey(c)) {
                char2Once.put(c, false);
            } else {
                char2Once.put(c, true);
            }
        }
        // chars 本身就有序
        for (char c : chars) {
            if (char2Once.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
