package com.algorithm.dataStructure.array.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * @author dragonsong  @date 2022/8/4
 */
public class FindContinuousSequence {

    /*
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 95.10%
     * 的用户
     * 内存消耗：
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 93.17%
     * 的用户
     * 通过测试用例：
     * 32 / 32
     */

    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int r = 0;
        int sum = 0;
        for (int l = 1; l < target; l++) {
            // 更新当前轮的和、右指针
            sum = sum == 0 ? 0 : sum - (l - 1);
            r = r == 0 ? l : r;

            while (sum < target) {
                sum += r;
                r++;
            }
            if (sum > target) {
                continue;
            }
            // sum == target
            int[] arr = new int[r - l];
            for (int i = l; i < r; i++) {
                arr[i - l] = i;
            }
            ans.add(arr);
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
