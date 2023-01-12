package com.algorithm.string;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/
 *
 * @author songhuilong001  @date 2023/1/12
 */
public class EvaluateTheBracketPairsOfAString {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> k2V = knowledge.stream()
                .collect(Collectors.toMap(
                        knowledgeArr -> knowledgeArr.get(0),
                        knowledgeArr -> knowledgeArr.get(1)
                ));
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                // 取出 () 中的单词
                StringBuilder word = new StringBuilder();
                while (i + 1 < n && s.charAt(i + 1) != ')') {
                    i++;
                    word.append(s.charAt(i));
                }
                i++;
                ans.append(k2V.getOrDefault(word.toString(), "?"));
            } else {
                // 不需要替换的字符
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
