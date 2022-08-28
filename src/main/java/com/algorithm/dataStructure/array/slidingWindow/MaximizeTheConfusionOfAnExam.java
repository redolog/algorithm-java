package com.algorithm.dataStructure.array.slidingWindow;

/**
 * https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/
 *
 * @author dragonsong  @date 2022/8/28
 */
public class MaximizeTheConfusionOfAnExam {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(calc(answerKey, k, 'T'), calc(answerKey, k, 'F'));
    }

    // 计算k个非c替换操作下，c连续最多的串
    private int calc(String answerKey, int k, char c) {
        // l表示当前字符起始的起点
        // r在区间内挪动
        int l = 0, r = 0, n = answerKey.length(), otherCnt = 0, ans = 0;
        while (r < n) {
            // 非c计数
            otherCnt += answerKey.charAt(r) != c ? 1 : 0;

            // 当前窗口内非c字符超过了k，尝试将左侧收回
            while (otherCnt > k) {
                otherCnt -= answerKey.charAt(l) != c ? 1 : 0;
                l++;
            }
            // 维护当前窗口更大值
            ans = Math.max(ans, r - l + 1);
            // r正常右挪动
            r++;
        }
        return ans;
    }
}
