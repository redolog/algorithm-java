package com.algorithm.string;

/**
 * 6158. 字母移位 II 显示英文描述
 * 题目难度Medium
 * 给你一个小写英文字母组成的字符串 s 和一个二维整数数组 shifts ，其中 shifts[i] = [starti, endi, directioni] 。
 * 对于每个 i ，将 s 中从下标 starti 到下标 endi （两者都包含）所有字符都进行移位运算，
 * 如果 directioni = 1 将字符向后移位，如果 directioni = 0 将字符向前移位。
 * <p>
 * 将一个字符 向后 移位的意思是将这个字符用字母表中 下一个 字母替换（字母表视为环绕的，所以 'z' 变成 'a'）。
 * 类似的，将一个字符 向前 移位的意思是将这个字符用字母表中 前一个 字母替换（字母表是环绕的，所以 'a' 变成 'z' ）。
 * <p>
 * 请你返回对 s 进行所有移位操作以后得到的最终字符串。
 *
 * @author dragonsong  @date 2022/8/20
 */
public class ShiftingLettersII {

    static class DiffArr {
        char[] alphaTable = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        public String shiftingLetters(String s, int[][] shifts) {
            char[] arr = s.toCharArray();
            int n = arr.length;

            // 数组，每一位存储当前字符与前序字符的距离
            int[] diffArr = new int[n];
            char prev = 'a';
            // O(n)
            for (int i = 0; i < n; i++) {
                diffArr[i] = arr[i] - prev;
                prev = arr[i];
            }

            // O(n)
            for (int[] shift : shifts) {
                int start = shift[0];
                int end = shift[1];
                int direction = shift[2];
                if (direction == 0) {
                    // 前移
                    direction = -1;
                }

                diffArr[start] += direction;
                if (end + 1 < n) {
                    diffArr[end + 1] -= direction;
                }
            }

            prev = 'a';
            for (int i = 0; i < n; i++) {
                arr[i] = distance2Char(diffArr[i], prev);
                prev = arr[i];
            }
            return String.valueOf(arr);
        }

        public char distance2Char(int distance, char prev) {
            if (distance == 0) {
                return prev;
            }
            distance += prev - 'a';
            if (distance < 0) {
                distance = distance % 26 + 26;
            } else {
                distance = distance % 26;
            }
            return alphaTable[distance];
        }
    }

    static class BF {
        /**
         * 结果：超时
         */

        char[] alphaTable = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        /**
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(26)
         */
        public String shiftingLetters(String s, int[][] shifts) {
            char[] arr = s.toCharArray();
            for (int[] shift : shifts) {
                int start = shift[0];
                int end = shift[1];
                int direction = shift[2];
                for (int i = start; i <= end; i++) {
                    char currC = arr[i];
                    if (direction == 0) {
                        // 前移
                        arr[i] = alphaTable[getPrevIdx(currC)];
                    } else {
                        // 后移
                        arr[i] = alphaTable[getNextIdx(currC)];
                    }
                }
            }
            return String.valueOf(arr);
        }

        public int getPrevIdx(char c) {
            return (c - 'a' + 25) % 26;
        }

        public int getNextIdx(char c) {
            return (c - 'a' + 1) % 26;
        }
    }


}
