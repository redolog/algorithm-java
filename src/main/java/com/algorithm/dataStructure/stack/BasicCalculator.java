package com.algorithm.dataStructure.stack;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * @author DragonSong  @date 2021/1/8
 * @link {https://leetcode-cn.com/problems/basic-calculator/}
 */

public class BasicCalculator {


    /**
     * 前缀表示法 （+ 3 4 ）
     * 中缀表示法 （3 + 4）
     * 后缀表示法 （3 4 + ）
     */
    public int calculate(String s) {
        if (null == s) {
            return -1;
        }
        String replaced = s.replace(" ", "");
        if (replaced.length() == 0) {
            return -1;
        }
        for (char c : replaced.toCharArray()) {

        }

        return -1;
    }
}
