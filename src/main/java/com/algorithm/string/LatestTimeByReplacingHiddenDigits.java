package com.algorithm.string;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * <p>
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * <p>
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * 示例 2：
 * <p>
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * 示例 3：
 * <p>
 * 输入：time = "1?:22"
 * 输出："19:22"
 * <p>
 * <p>
 * 提示：
 * <p>
 * time 的格式为 hh:mm
 * 题目数据保证你可以由输入的字符串生成有效的时间
 * <p>
 * https://leetcode.cn/problems/latest-time-by-replacing-hidden-digits/
 *
 * @author dragonsong  @date 2022/7/29
 */
public class LatestTimeByReplacingHiddenDigits {

    public String maximumTime(String time) {
        // 09:59
        // 19:59
        // 23:59
        char[] arr = time.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '?') {
                continue;
            }
            if (i == 0) {
                if (arr[1] == '?') {
                    arr[0] = '2';
                    arr[1] = '3';
                } else {
                    if (arr[1] > '3') {
                        arr[0] = '1';
                    } else {
                        arr[0] = '2';
                    }
                }
            } else if (i == 1) {
                if (arr[0] < '2') {
                    arr[1] = '9';
                } else {
                    arr[1] = '3';
                }
            } else if (i == 3) {
                arr[3] = '5';
            } else {
                arr[4] = '9';
            }
        }
        return String.valueOf(arr);
    }
}
