package com.algorithm.string;

/**
 * 2000. 反转单词前缀
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
 * <p>
 * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
 * 返回 结果字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abcdefd", ch = "d"
 * 输出："dcbaefd"
 * 解释："d" 第一次出现在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "dcbaefd" 。
 * 示例 2：
 * <p>
 * 输入：word = "xyxzxe", ch = "z"
 * 输出："zxyxxe"
 * 解释："z" 第一次也是唯一一次出现是在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "zxyxxe" 。
 * 示例 3：
 * <p>
 * 输入：word = "abcd", ch = "z"
 * 输出："abcd"
 * 解释："z" 不存在于 word 中。
 * 无需执行反转操作，结果字符串是 "abcd" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 250
 * word 由小写英文字母组成
 * ch 是一个小写英文字母
 * <p>
 * https://leetcode.cn/problems/reverse-prefix-of-word/
 *
 * @author dragonsong  @date 2022/7/16
 */
public class ReversePrefixOfWord {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 20.93%
     * 的用户
     * 通过测试用例：
     * 112 / 112
     */

    public String reversePrefix(String word, char ch) {
        char[] charArr = word.toCharArray();
        int chIdx = -1;

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ch) {
                chIdx = i;
                break;
            }
        }
        if (chIdx == -1) {
            return word;
        }

        int l = 0;
        int r = chIdx;
        while (l <= r) {
            char lTmp = charArr[l];
            charArr[l] = charArr[r];
            charArr[r] = lTmp;
            ++l;
            --r;
        }
        return String.valueOf(charArr);

    }

    static class BuilderSolution {
        /*
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 40 MB
         * , 在所有 Java 提交中击败了
         * 8.16%
         * 的用户
         * 通过测试用例：
         * 112 / 112
         */

        public String reversePrefix(String word, char ch) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ch) {
                    String prefix = word.substring(0, i + 1);
                    return new StringBuilder(prefix).reverse().append(word.substring(i + 1)).toString();
                }
            }
            return word;
        }
    }
}
