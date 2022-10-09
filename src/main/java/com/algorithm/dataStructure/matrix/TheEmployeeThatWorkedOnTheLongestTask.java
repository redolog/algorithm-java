package com.algorithm.dataStructure.matrix;

/**
 * https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/
 *
 * @author songhuilong  @date 2022/10/9
 */
public class TheEmployeeThatWorkedOnTheLongestTask {

    /**
     * 记录最大工时，同时判断是否工时等于最大工时且工号更靠前
     */
    public int hardestWorker(int n, int[][] logs) {
        // longest表示最大工时
        int longest = logs[0][1], ans = 0;
        for (int i = 1; i < logs.length; i++) {
            if (logs[i][1] - logs[i - 1][1] > longest) {
                longest = logs[i][1] - logs[i - 1][1];
                ans = i;
            }
            // 工时相等，取工号靠前的
            if (logs[i][1] - logs[i - 1][1] == longest && logs[i][0] < logs[ans][0]) {
                ans = i;
            }
        }
        return logs[ans][0];
    }
}