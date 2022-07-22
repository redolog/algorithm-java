package com.algorithm.backtrack;

/**
 * 60. 排列序列
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 3
 * 输出："213"
 * 示例 2：
 * <p>
 * 输入：n = 4, k = 9
 * 输出："2314"
 * 示例 3：
 * <p>
 * 输入：n = 3, k = 1
 * 输出："123"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * 1 <= k <= n!
 * <p>
 * https://leetcode.cn/problems/permutation-sequence/
 *
 * @author dragonsong  @date 2022/6/29
 */
public class PermutationSequence {

    /**
     * 执行用时：
     * 739 ms
     * , 在所有 Java 提交中击败了
     * 14.27%
     * 的用户
     * 内存消耗：
     * 41.4 MB
     * , 在所有 Java 提交中击败了
     * 12.12%
     * 的用户
     * 通过测试用例：
     * 200 / 200
     */

    int k;

    String ans;

    public static void main(String[] args) {
        StringBuilder path = new StringBuilder();
        System.out.println(path.length());
        path.append(1);
        System.out.println(path.length());
        path.append(22);
        System.out.println(path.length());
        path.delete(path.length() - "22".length(), path.length());
        System.out.println(path);
    }

    public String getPermutation(int n, int k) {
        this.k = k;

        // 排列问题，是典型的树形遍历问题，我们使用深度有限遍历的方式走访每个可能的分支
        // 使用一个 path 容器，存放当前分支下的数据，回溯即回撤时从末尾回退数据，使用一个栈结构保存
        StringBuilder path = new StringBuilder(n);

        boolean[] usedArr = new boolean[n];

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        dfs(nums, n, path, usedArr);

        return ans;
    }

    private void dfs(int[] nums, int n, StringBuilder path, boolean[] usedArr) {
        if (path.length() == n) {
            --k;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (usedArr[i]) {
                // 在当前树路径上该节点已被选
                continue;
            }

            usedArr[i] = true;
            path.append(nums[i]);
            dfs(nums, n, path, usedArr);
            if (k == 0) {
                ans = path.toString();
                return;
            }
            // 回溯：回退之前的状态
            usedArr[i] = false;
            path.deleteCharAt(path.length() - String.valueOf(nums[i]).length());
        }
    }
}
