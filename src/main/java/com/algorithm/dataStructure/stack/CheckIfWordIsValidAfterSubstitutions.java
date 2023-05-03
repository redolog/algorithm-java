package com.algorithm.dataStructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/
 *
 * @author songhuilong001  @date 2023/5/3
 */
public class CheckIfWordIsValidAfterSubstitutions {

    /**
     * 消消乐版本：凑够abc即消除
     * 尝试回退 abc 插入操作：
     * 依次将字符入栈（保持原始顺序、记录删减状态），当栈顶为 abc 时，将abc出栈（此时就实现了abc插入的回退，消消乐）
     * 最后如果所有字符都消除完，则符合题目规则
     */
    static class Match3Solution {
        public boolean isValid(String s) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                builder.append(s.charAt(i));
                if (builder.length() >= 3 && "abc".equals(builder.substring(builder.length() - 3))) {
                    builder.delete(builder.length() - 3, builder.length());
                }
            }
            return builder.length() == 0;
        }
    }

    /**
     * 括号匹配思路：
     * 将abc看做一个括号对：
     * 1. 依次遍历入参字符串；
     * 2. 当前字符为a时，入栈；
     * 3. 当前字符为b时，判断前序字符，前序字符为a时，b入栈（尝试碰到下一个c组成abc），前序字符不为a时，字符串整体非法，提前返回false；
     * 4. 当前字符为c时，判断前序串是否为abc，是则出栈abc，否则字符串整体非法，提前返回false；
     * <p>
     * 其中判断前序字符或者串时，空栈看做非法情况。由于b已经判断了a的前序合法性，因此栈中可保留ab，也可以只保留栈顶的b。
     */
    static class ParenthesesMatchSolution {
        public boolean isValid(String s) {
            Deque<Character> stk = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'a') {
                    stk.offerLast(c);
                }
                if (c == 'b') {
                    if (stk.isEmpty() || stk.peekLast() != 'a') {
                        return false;
                    }
                    // 前序的a置换为栈顶的b
                    stk.pollLast();
                    stk.offerLast(c);
                }
                if (c == 'c') {
                    if (stk.isEmpty() || stk.peekLast() != 'b') {
                        return false;
                    }
                    stk.pollLast();
                }
            }
            return stk.isEmpty();
        }
    }
}
