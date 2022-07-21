package com.algorithm.dataStructure.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * 944. 删列造序
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 * <p>
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 * <p>
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 * <p>
 * 返回你需要删除的列数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["cba","daf","ghi"]
 * 输出：1
 * 解释：网格示意如下：
 * cba
 * daf
 * ghi
 * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
 * 示例 2：
 * <p>
 * 输入：strs = ["a","b"]
 * 输出：0
 * 解释：网格示意如下：
 * a
 * b
 * 只有列 0 这一列，且已经按升序排列，所以不用删除任何列。
 * 示例 3：
 * <p>
 * 输入：strs = ["zyx","wvu","tsr"]
 * 输出：3
 * 解释：网格示意如下：
 * zyx
 * wvu
 * tsr
 * 所有 3 列都是非升序排列的，所以都要删除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 1000
 * strs[i] 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 *
 * @author dragonsong  @date 2022/7/21
 */
public class DeleteColumnToMakeSorted {

    static class SetSolution {
        /*
         * 执行用时：
         * 7 ms
         * , 在所有 Java 提交中击败了
         * 82.04%
         * 的用户
         * 内存消耗：
         * 41.7 MB
         * , 在所有 Java 提交中击败了
         * 24.05%
         * 的用户
         * 通过测试用例：
         * 85 / 85
         */
        public int minDeletionSize(String[] strs) {
            if (strs == null || strs[0].length() == 0) {
                return -1;
            }
            int m = strs.length;
            int n = strs[0].length();

            Set<Integer> cols = new HashSet<>();

            for (int col = 0; col < n; col++) {
                int prev = Integer.MIN_VALUE;
                for (int row = 0; row < m; row++) {
                    int curr = strs[row].charAt(col) - 'a';
                    if (curr < prev) {
                        cols.add(col);
                    }
                    prev = curr;
                }
            }
            return cols.size();
        }
    }

    static class CntSolution {
        /*
         * 执行用时：
         * 4 ms
         * , 在所有 Java 提交中击败了
         * 99.47%
         * 的用户
         * 内存消耗：
         * 41.3 MB
         * , 在所有 Java 提交中击败了
         * 79.42%
         * 的用户
         * 通过测试用例：
         * 85 / 85
         */
        public int minDeletionSize(String[] strs) {
            if (strs == null || strs[0].length() == 0) {
                return -1;
            }
            int m = strs.length;
            int n = strs[0].length();

            int ans = 0;

            for (int col = 0; col < n; col++) {
                int prev = Integer.MIN_VALUE;
                for (int row = 0; row < m; row++) {
                    int curr = strs[row].charAt(col) - 'a';
                    if (curr < prev) {
                        ++ans;
                        // 当前列已出局，跳到下一列
                        break;
                    }
                    prev = curr;
                }
            }
            return ans;
        }
    }


}
