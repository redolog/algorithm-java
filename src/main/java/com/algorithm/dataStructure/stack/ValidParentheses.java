package com.algorithm.dataStructure.stack;

import java.util.*;

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

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.96%
     * 的用户
     * 内存消耗：
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 98.54%
     * 的用户
     * 通过测试用例：
     * 91 / 91
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }
        // 使用一个栈结构保存遍历结果，给定s可以提前确定栈的最大长度，此举可提高空间效率
        Deque<Character> stack = new ArrayDeque<>(s.length() / 2 + 1);
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }

            // 左括号
            char left = stack.pop();
            if (left == '(') {
                if (c != ')') {
                    return false;
                }
            } else if (left == '[') {
                if (c != ']') {
                    return false;
                }
            } else if (left == '{') {
                if (c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
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

    private boolean iterateInOrderVersion(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
