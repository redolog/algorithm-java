package com.algorithm.string;

/**
 * https://leetcode.cn/problems/goal-parser-interpretation/
 *
 * @author DragonSong  @date 2022/11/6
 */
public class GoalParserInterpretation {

    public String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        int n = command.length();
        for (int i = 0; i < n; i++) {
            char currC = command.charAt(i);
            if (currC == 'G') {
                builder.append('G');
            }
            if (currC == '(') {
                if (i + 1 < n && command.charAt(i + 1) == ')') {
                    builder.append('o');
                    i += 1;
                }
                if (i + 3 < n && command.charAt(i + 3) == ')' && command.charAt(i + 1) == 'a' && command.charAt(i + 2) == 'l') {
                    builder.append("al");
                    i += 3;
                }
            }
        }
        return builder.toString();
    }
}
