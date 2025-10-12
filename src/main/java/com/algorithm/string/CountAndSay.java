package com.algorithm.string;


/**
 * https://leetcode.cn/problems/count-and-say/description/
 *
 * @author songhuilong  @date 2025/10/12
 */
public class CountAndSay {

    public static class RecursionSolution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            return rle(countAndSay(n - 1));
        }

        public String rle(String code) {
            if (null == code || code.length() == 0) {
                return "";
            }
            // 当前段元素值
            int curr = code.charAt(0);
            // 当前段元素数
            int cnt = 1;

            // rle拼接的值
            StringBuilder builder = new StringBuilder();

            int n = code.length();
            for (int i = 1; i < n; i++) {
                if (code.charAt(i) == curr) {
                    cnt++;
                } else {
                    // 拼接rle值
                    builder.append(cnt).append(curr - '0');
                    // 更新下一个段计数
                    curr = code.charAt(i);
                    cnt = 1;
                }
            }
            // 拼接rle值
            builder.append(cnt).append(curr - '0');
            return builder.toString();
        }
    }

    public static class IterationSolution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            String cas = "1";
            for (int i = 2; i <= n; i++) {
                cas = rle(cas);
            }
            return cas;
        }

        public String rle(String s) {
            if (null == s || s.length() == 0) {
                return "";
            }
            // 哨兵，s循环一次，并且完成所有拼接操作
            String sentinel = s + "x";

            // 当前段元素值
            char curr = s.charAt(0);
            // 当前段元素计数
            int cnt = 1;
            // rle编码结果
            StringBuilder builder = new StringBuilder();

            int n = sentinel.length();
            for (int i = 1; i < n; i++) {
                if (sentinel.charAt(i) == curr) {
                    cnt++;
                } else {
                    // 拼接rle
                    builder.append(cnt)
                            .append(curr - '0');
                    // 段重新计数
                    cnt = 1;
                    curr = sentinel.charAt(i);
                }
            }
            return builder.toString();
        }
    }

}
