package com.algorithm.dataStructure.array.diff;

/**
 * 370. 区间加法
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k​​​​​​​ 个更新的操作。
 * <p>
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * <p>
 * 请你返回 k 次操作后的数组。
 * <p>
 * 示例:
 * <p>
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * 解释:
 * <p>
 * 初始状态:
 * [0,0,0,0,0]
 * <p>
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 * <p>
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 * <p>
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 * <p>
 * https://leetcode.cn/problems/range-addition/
 *
 * @author dragonsong  @date 2022/7/24
 */
public class RangeAddition {

    static class BF {
        public int[] getModifiedArray(int n, int[][] updates) {
            int[] arr = new int[n];

            for (int[] update : updates) {
                int startIdxInclusive = update[0];
                int endIdxInclusive = update[1];
                int inc = update[2];
                for (int i = startIdxInclusive; i <= endIdxInclusive; i++) {
                    arr[i] += inc;
                }
            }

            return arr;
        }
    }

    static class DiffArray {

        /*
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 45.7 MB
         * , 在所有 Java 提交中击败了
         * 56.37%
         * 的用户
         * 通过测试用例：
         * 18 / 18
         */
        public int[] getModifiedArray(int n, int[][] updates) {
            // 差分数组， diff[i]表示 nums[i]-nums[i-1]
            int[] diff = new int[n];
            // 对差分数组操作
            for (int[] update : updates) {
                int startIdxInclusive = update[0];
                int endIdxInclusive = update[1];
                int inc = update[2];

                diff[startIdxInclusive] += inc;
                if (endIdxInclusive + 1 < n) {
                    diff[endIdxInclusive + 1] -= inc;
                }
            }
            // 根据差分数组还原 原数组
//            int[] arr = new int[n];
//            arr[0] = diff[0];
            for (int i = 1; i < n; i++) {
                diff[i] = diff[i - 1] + diff[i];
            }
            return diff;
        }
    }

}
