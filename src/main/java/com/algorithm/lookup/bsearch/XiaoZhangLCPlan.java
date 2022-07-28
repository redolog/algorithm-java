package com.algorithm.lookup.bsearch;

/**
 * LCP 12. 小张刷题计划
 * 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
 * <p>
 * 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
 * <p>
 * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [1,2,3,3], m = 2
 * <p>
 * 输出：3
 * <p>
 * 解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：time = [999,999,999], m = 4
 * <p>
 * 输出：0
 * <p>
 * 解释：在前三天中，小张每天求助小杨一次，这样他可以在三天内完成所有的题目并不花任何时间。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= time.length <= 10^5
 * 1 <= time[i] <= 10000
 * 1 <= m <= 1000
 * <p>
 * https://leetcode.cn/problems/xiao-zhang-shua-ti-ji-hua/
 *
 * @author dragonsong  @date 2022/7/27
 */
public class XiaoZhangLCPlan {

    /*
     * 执行用时：
     * 11 ms
     * , 在所有 Java 提交中击败了
     * 13.27%
     * 的用户
     * 内存消耗：
     * 48.9 MB
     * , 在所有 Java 提交中击败了
     * 36.25%
     * 的用户
     * 通过测试用例：
     * 39 / 39
     */

    public int minTime(int[] time, int m) {
        // 速度边界，最慢应该是小张不做题，速度0，最快应该是一口气做完所有题
        int l = 0, r = 0;
        for (int t : time) {
            r += t;
        }
        int min = l;

        // m天时间的前提下，速度尽可能小
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int t = speed2Time(mid, time);
            if (t <= m) {
                if (mid == min || speed2Time(mid - 1, time) > m) {
                    return mid;
                }
                // 未到左侧边界，往左移动
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // m天内，每天以耗时t的速度做题，能做多少道题
    // time[i]表示每道题耗时
    // 速度越大，时间越少，非严格递减
    // 大于speed的，肯定得求助
    public int speed2Time(int speed, int[] time) {
        // 最终消耗的时间
        int ans = 0;
        // 当前一天中最大的值，这个值交给小杨求助解决
        int groupMax = 0;
        // 当前组遍历的前序和
        int preSum = 0;
        for (int i = 0; i < time.length; i++) {
            int t = time[i];
            groupMax = Math.max(t, groupMax);
            // 当前这组题小张一个人就搞定了
            if (preSum + t <= speed) {
                preSum += t;
                continue;
            }
            // 当前这组整体超过了我们的速度，并且减去一个最大值交给小杨，我们就可以处理完
            if (preSum + t - groupMax < speed) {
                // 去掉一个最大值，发现还小于speed，说明我们可以尝试再加一道
                preSum += t;
            } else if (preSum + t - groupMax == speed) {
                // 小张+小杨刚好搞定
                ans++;
                preSum = 0;
                groupMax = 0;
            } else {
                // 俩人加起来也搞不定，最后一道顺延到下一组处理
                // preSum + t - groupMax > speed
                // 消耗一天
                ans++;
                // 并且最后一道题不能忽略
                preSum = t;
                groupMax = t;
            }
        }
        if (preSum > 0) {
            ans++;
        }
        return ans;
    }

}
