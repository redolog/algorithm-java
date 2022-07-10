package com.algorithm.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.07. 无重复字符串的排列组合
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * https://leetcode.cn/problems/permutation-i-lcci/
 *
 * @author DragonSong  @date 2022/7/10
 */
public class PermutationILcci {

    /*
     * 执行用时：
     * 9 ms
     * , 在所有 Java 提交中击败了
     * 71.04%
     * 的用户
     * 内存消耗：
     * 49.2 MB
     * , 在所有 Java 提交中击败了
     * 44.93%
     * 的用户
     * 通过测试用例：
     * 30 / 30
     */

    public String[] permutation(String s) {
        List<String> list=new ArrayList<>();

        boolean[] used=new boolean[s.length()];
        StringBuilder builder=new StringBuilder();

        dfs(s,used,list,builder);

        return list.toArray(new String[0]);
    }

    private void dfs(String s, boolean[] used, List<String> list, StringBuilder builder) {
        if (s.length()==builder.length()) {
            list.add(builder.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }
            used[i]=true;
            builder.append(s.charAt(i));

            dfs(s,used,list,builder);

            used[i]=false;
            builder.deleteCharAt(builder.length()-1);
        }

    }
}
