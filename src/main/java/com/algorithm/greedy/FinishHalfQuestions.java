package com.algorithm.greedy;

import java.util.Arrays;

/**
 * LCS 02. 完成一半题目
 * 有 N 位扣友参加了微软与力扣举办了「以扣会友」线下活动。主办方提供了 2*N 道题目，整型数组 questions 中每个数字对应了每道题目所涉及的知识点类型。
 * 若每位扣友选择不同的一题，请返回被选的 N 道题目至少包含多少种知识点类型。
 * <p>
 * 示例 1：
 * <p>
 * 输入：questions = [2,1,6,2]
 * <p>
 * 输出：1
 * <p>
 * 解释：有 2 位扣友在 4 道题目中选择 2 题。
 * 可选择完成知识点类型为 2 的题目时，此时仅一种知识点类型
 * 因此至少包含 1 种知识点类型。
 * <p>
 * 示例 2：
 * <p>
 * 输入：questions = [1,5,1,3,4,5,2,5,3,3,8,6]
 * <p>
 * 输出：2
 * <p>
 * 解释：有 6 位扣友在 12 道题目中选择题目，需要选择 6 题。
 * 选择完成知识点类型为 3、5 的题目，因此至少包含 2 种知识点类型。
 * <p>
 * 提示：
 * <p>
 * questions.length == 2*n
 * 2 <= questions.length <= 10^5
 * 1 <= questions[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/WqXACV/
 *
 * @author dragonsong  @date 2022/7/29
 */
public class FinishHalfQuestions {

    /*
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 60.07%
     * 的用户
     * 内存消耗：
     * 50 MB
     * , 在所有 Java 提交中击败了
     * 47.53%
     * 的用户
     * 通过测试用例：
     * 39 / 39
     */

    /**
     * 统计每道题的题型，根据题型题量排序，从最多的题型开始选人！
     */
    public int halfQuestions(int[] questions) {
        // questions[i] 表示每道题的题型
        // 题目所求，n个人，每个人一道题，选中最少的题型

        // 题目数量
        int m = questions.length;
        // 参考人数
        int n = m / 2;

        int[] statArr = new int[1001];
        for (int question : questions) {
            statArr[question]++;
        }
        Arrays.sort(statArr);
        // ans表示选的题型数
        int ans = 0;
        for (int i = statArr.length - 1; i >= 0; i--) {
            if (n <= 0) {
                break;
            }
            n -= statArr[i];
            ans++;
        }

//        // 先统计类型对应题数
//        Map<Integer, Integer> type2Cnt = new HashMap<>();
//        for (int type : questions) {
//            type2Cnt.put(type, type2Cnt.getOrDefault(type, 0) + 1);
//        }
//        // 对选中题型数量降序排序
//        int[] arr = new int[type2Cnt.keySet().size()];
//        int i = 0;
//        for (Map.Entry<Integer, Integer> entry : type2Cnt.entrySet()) {
//            arr[i++] = entry.getValue();
//        }
//        Arrays.sort(arr);
//        int ans = 0;
//        for (int j = arr.length - 1; j >= 0; j--) {
//            if (n <= 0) {
//                break;
//            }
//            n -= arr[j];
//            ans++;
//        }
        return ans;
    }
}
