package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/longest-univalue-path/submissions/
 *
 * @author dragonsong  @date 2022/9/2
 */
public class LongestUnivaluePath {

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;

        // dfs求各个节点的同值路径长度
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            // 节点空，说明到了树底
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);

        // 检查左右子节点的值是否与父节点同
        int lL = 0, rL = 0;
        if (node.left != null && node.left.val == node.val) {
            lL = l;
        }
        if (node.right != null && node.right.val == node.val) {
            rL = r;
        }
        ans = Math.max(ans, lL + rL);
        // 左右任意一边只要有同值出现，node的同值路径长度就可以 1+l or r
        return Math.max(lL, rL) + 1;
    }
}
