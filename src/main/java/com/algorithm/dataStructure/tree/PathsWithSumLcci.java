package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/paths-with-sum-lcci/
 *
 * @author dragonsong  @date 2022/8/16
 */
public class PathsWithSumLcci {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 从原根dfs搜索
        int ans = dfs(root, sum);
        // 从root子节点为根开始计数，累加
        ans += pathSum(root.left, sum);
        ans += pathSum(root.right, sum);
        return ans;
    }

    private int dfs(TreeNode node, int sum) {
        int ans = 0;
        if (node == null) {
            return ans;
        }
        if (sum == node.val) {
            ans++;
        }
        ans += dfs(node.left, sum - node.val);
        ans += dfs(node.right, sum - node.val);
        return ans;
    }

}
