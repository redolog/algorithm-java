package com.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/
 *
 * @author songhuilong  @date 2022/10/27
 */
public class GreatestEnglishLetterInUpperAndLowerCase {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 32) == (1L << 32));
    }

    static class BitSolution {
        /**
         * A:65  Z:90  a:97  z:122
         * 我们以 A开头，存储A-Z，需要26个位
         * 接着存储 a-z，使用 32-57位
         * 可得，我们需要一个64位的空间，使用位运算即可表达某个字符是否存在的语义。
         * <p>
         * 因此，我们仅需一个long（int64）型变量，空间效率相较 SetSolution 大大提升。
         * <p>
         * 时间：O(n)
         * 空间：O(1)
         */
        public String greatestLetter(String s) {
            // 每个位上记录了字符是否存在，1表示存在
            long int64 = 0L;
            for (int i = 0; i < s.length(); i++) {
                int64 |= (1L << (s.charAt(i) - 'A'));
            }
            int ans = -1;
            for (int i = 0; i < s.length(); i++) {
                int upper = s.charAt(i) - 'A';
                if (upper < 0 || upper > 25) {
                    // 只判断大写字母
                    continue;
                }
                int lower = upper + 32;
                if ((int64 & (1L << lower)) != 0 && upper > ans) {
                    ans = upper;
                }
            }
            return ans == -1 ? "" : String.valueOf((char) (ans + 'A'));
        }
    }

    static class SetSolution {
        /**
         * 时间：O(n)
         * 空间：O(n)
         */
        public String greatestLetter(String s) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add((int) s.charAt(i));
            }
            int ans = -1;
            for (int i = 0; i < s.length(); i++) {
                int upper = s.charAt(i);
                int lower = upper + 32;
                if (set.contains(lower) && upper > ans) {
                    ans = upper;
                }
            }
            return ans == -1 ? "" : String.valueOf((char) ans);
        }
    }
}
