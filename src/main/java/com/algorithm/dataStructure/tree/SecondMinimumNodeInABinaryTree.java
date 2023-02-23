package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/
 *
 * @author songhuilong  @date 2023/2/23
 */
public class SecondMinimumNodeInABinaryTree {

    int ans;

    int min;

    boolean found;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        ans = Integer.MAX_VALUE;
        found = false;
        dfs(root);
        return found ? ans : -1;
    }

    private void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }
        if (curr.val > min && ans >= curr.val) {
            ans = curr.val;
            found = true;
        }
        dfs(curr.left);
        dfs(curr.right);
    }
}
