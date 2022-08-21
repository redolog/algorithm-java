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

        public String shiftingLetters(String s, int[][] shifts) {
            char[] charArr = s.toCharArray();
            int n = charArr.length;

            // 差分数组：每一位存储当前位置的移动量
            int[] diffArr = new int[n + 1];
            // O(n)
            for (int[] shift : shifts) {
                int start = shift[0];
                int end = shift[1];
                int move = shift[2];
                if (move == 0) {
                    // 前移
                    move = -1;
                }

                diffArr[start] += move;
                diffArr[end + 1] -= move;
            }
            int[] moveArr = new int[n];
            moveArr[0] = diffArr[0];
            for (int i = 1; i < n; i++) {
                moveArr[i] = moveArr[i - 1] + diffArr[i];
            }

            for (int i = 0; i < n; i++) {
                // 原距离 + 移动距离
                int distance = (charArr[i] - 'a' + moveArr[i]) % 26;
                if (distance < 0) {
                    distance += 26;
                }
                charArr[i] = (char) (distance + 'a');
            }
            return String.valueOf(charArr);
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
