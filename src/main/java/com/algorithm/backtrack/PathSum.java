package com.algorithm.backtrack;

import com.algorithm.dataStructure.tree.TreeNode;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * <p>
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * https://leetcode.cn/problems/path-sum/
 *
 * @author dragonsong  @date 2022/7/20
 */
public class PathSum {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 7.41%
     * 的用户
     * 通过测试用例：
     * 117 / 117
     */
    static class DFS {
        int sum;

        int targetSum;

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            this.targetSum = targetSum;
            this.sum = 0;
            sum += root.val;
            if (sum == targetSum && root.left == null && root.right == null) {
                return true;
            }
            return dfs(root.left) || dfs(root.right);
        }

        private boolean dfs(TreeNode node) {
            if (node == null) {
                return false;
            }
            sum += node.val;
            if (sum == targetSum && node.left == null && node.right == null) {
                return true;
            }
            if (dfs(node.left) || dfs(node.right)) {
                return true;
            }
            sum -= node.val;
            return false;
        }
    }

    static class Recursion {
        /*
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 41.5 MB
         * , 在所有 Java 提交中击败了
         * 16.81%
         * 的用户
         * 通过测试用例：
         * 117 / 117
         */
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return dfs(root, targetSum);
        }

        private boolean dfs(TreeNode node, int targetSum) {
            if (node == null) {
                return false;
            }
            if (node.left == null && node.right == null && node.val == targetSum) {
                return true;
            }
            return dfs(node.left, targetSum - node.val) || dfs(node.right, targetSum - node.val);
        }
    }

}
