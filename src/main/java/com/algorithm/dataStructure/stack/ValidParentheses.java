package com.algorithm.dataStructure.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author DragonSong  @date 2021/1/7
 * @link {https://leetcode-cn.com/problems/valid-parentheses/}
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        if (null == s || s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }
        return rawJudgeVersion(s);
    }

    private boolean cacheParenthesesVersion(String s) {
        Map<Character, Character> right2Left = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (right2Left.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(right2Left.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean rawJudgeVersion(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '}') {
                if (stack.isEmpty() || !stack.pop().equals('{')) {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || !stack.pop().equals('(')) {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || !stack.pop().equals('[')) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
