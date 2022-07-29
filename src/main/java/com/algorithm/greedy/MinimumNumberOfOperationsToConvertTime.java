package com.algorithm.greedy;

/**
 * 2224. 转化时间需要的最少操作数
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 * <p>
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 * <p>
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 * <p>
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：current = "02:30", correct = "04:35"
 * 输出：3
 * 解释：
 * 可以按下述 3 步操作将 current 转换为 correct ：
 * - 为 current 加 60 分钟，current 变为 "03:30" 。
 * - 为 current 加 60 分钟，current 变为 "04:30" 。
 * - 为 current 加 5 分钟，current 变为 "04:35" 。
 * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
 * 示例 2：
 * <p>
 * 输入：current = "11:00", correct = "11:01"
 * 输出：1
 * 解释：只需要为 current 加一分钟，所以最小操作数是 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * current 和 correct 都符合 "HH:MM" 格式
 * current <= correct
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time/
 *
 * @author dragonsong  @date 2022/7/29
 */
public class MinimumNumberOfOperationsToConvertTime {

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 71.65%
     * 的用户
     * 内存消耗：
     * 39.6 MB
     * , 在所有 Java 提交中击败了
     * 74.80%
     * 的用户
     * 通过测试用例：
     * 255 / 255
     */

    // 小时数差，如果分钟数correct较大，用60分钟来操作，如果分钟数correct较小，用15/5/1来尝试
    // 分钟数差，依次用15/5/1来尝试
    // 整体贪心
    public int convertTime(String current, String correct) {
        int ans = 0;
        int currH = Integer.parseInt(current.substring(0, 2));
        int correctH = Integer.parseInt(correct.substring(0, 2));
        int currM = Integer.parseInt(current.substring(3));
        int correctM = Integer.parseInt(correct.substring(3));
        // 先处理小时数
        if (currM > correctM) {
            // 分钟数比目标分钟数大
            if (correctH - currH > 1) {
                // 先将小时差缩小到1，分钟差通过 15、5、1逼近
                ans += correctH - currH - 1;
            }
            // 小时差缩小到1时，将分钟数直接+60
            correctM += 60;
        } else {
            ans += correctH - currH;
        }
        // 分钟差通过 15、5、1逼近
        while (correctM > currM) {
            int diff = correctM - currM;
            if (diff >= 15) {
                correctM -= 15;
                ans++;
            } else if (diff >= 5) {
                correctM -= 5;
                ans++;
            } else {
                correctM -= diff;
                ans += diff;
            }
        }
        return ans;
    }
}
