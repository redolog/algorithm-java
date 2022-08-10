package com.algorithm.decimal;


/**
 * 640. Solve the Equation
 * Solve a given equation and return the value of 'x' in the form of a string "x=#value". The equation contains only '+', '-' operation, the variable 'x' and its coefficient. You should return "No solution" if there is no solution for the equation, or "Infinite solutions" if there are infinite solutions for the equation.
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of 'x' is an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: equation = "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * <p>
 * Input: equation = "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * <p>
 * Input: equation = "2x=x"
 * Output: "x=0"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= equation.length <= 1000
 * equation has exactly one '='.
 * equation consists of integers with an absolute value in the range [0, 100] without any leading zeros, and the variable 'x'.
 * <p>
 * https://leetcode.cn/problems/solve-the-equation/
 *
 * @author dragonsong  @date 2022/8/10
 */
public class SolveTheEquation {

    /**
     * 系数
     */
    int coefficient;
    /**
     * 等式左侧值
     */
    int val;

    public static boolean emptyStr(String str) {
        return null == str || str.length() == 0;
    }

    public String solveEquation(String equation) {
        // -增加+前缀，方便后面直接split将每一项因子拆开
        equation = equation.replace("-", "+-");
        String[] arr = equation.split("=");
        // 系数
        coefficient = 0;
        // 等式值
        val = 0;
        handle(arr[0].split("\\+"), true);
        handle(arr[1].split("\\+"), false);
        if (coefficient == 0) {
            if (val != 0) {
                return "No solution";
            }
            return "Infinite solutions";
        }

        return String.format("x=%d", -val / coefficient);
    }

    /**
     * 累加自变量系数值、等式值最终合并的和
     *
     * @param equationArr 等式一侧数组，包含数字、自变量
     * @param isLeft      左右分开+-
     */
    private void handle(String[] equationArr, boolean isLeft) {
        for (String s : equationArr) {
            if (emptyStr(s)) {
                continue;
            }
            // 系数当前叠加值 = 字符串.len==1 说明系数只能是1（x），否则判断是否为(-x)的情况，如果都不是，则取x前的int系数
            int coefficientAccumulate = s.length() == 1 ? 1 : s.substring(0, s.length() - 1).equals("-") ? -1 : Integer.parseInt(s.substring(0, s.length() - 1));
            if (isLeft) {
                if (s.contains("x")) {
                    this.coefficient += coefficientAccumulate;
                } else {
                    val += Integer.parseInt(s);
                }
            } else {
                if (s.contains("x")) {
                    this.coefficient -= coefficientAccumulate;
                } else {
                    val -= Integer.parseInt(s);
                }
            }
        }
    }
}
