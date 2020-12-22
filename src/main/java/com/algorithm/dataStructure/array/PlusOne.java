package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author DragonSong  @date 2020/12/22
 * @link {https://leetcode-cn.com/problems/plus-one/}
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] newDigits;
        boolean normal = true;
        newDigits = new int[len + 1];
//        if (digits[len - 1] == 9 && len == 1) {
//            normal = false;
////            newDigits = new int[]{1, 0};
//            return newDigits;
//
//        } else {
//            newDigits = new int[len];
//        }
        int[] carryArr = new int[len + 1];
        for (int i = len; i >= 0; i--) {
//            if (normal && i == 0) {
//                break;
//            }
            int sum = i == 0 ? 0 : digits[i - 1] + carryArr[i];
            if (sum == 9) {
                carryArr[i] = 1;
                newDigits[i] = (sum + 1) % 10;
            } else {
                carryArr[i] = 0;
                newDigits[i] = sum + 1;
            }

        }
        return newDigits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 3})));
    }

}
