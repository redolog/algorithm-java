package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/cousins-in-binary-tree/
 *
 * @author songhuilong  @date 2022/11/1
 */
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        // 找到x，设置depth为其深度值，并返回其父值
        int[] xDepthAndParent = getDepthAndParent(root, x);
        int[] yDepthAndParent = getDepthAndParent(root, y);
        if (xDepthAndParent == null || yDepthAndParent == null) {
            return false;
        }
        return xDepthAndParent[0] == yDepthAndParent[0] && xDepthAndParent[1] != yDepthAndParent[1];
    }

    private int[] getDepthAndParent(TreeNode root, int val) {
        int[] depthAndParent = dfs(root, root.left, val, 0);
        if (depthAndParent == null) {
            depthAndParent = dfs(root, root.right, val, 0);
        }
        return depthAndParent;
    }

    /**
     * 找到对应val所在depth以及parent值
     */
    private int[] dfs(TreeNode parent, TreeNode node, int val, int depth) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return new int[]{depth + 1, parent.val};
        }
        int[] depthAndParent = dfs(node, node.left, val, depth + 1);
        return depthAndParent == null ? dfs(node, node.right, val, depth + 1) : depthAndParent;
    }
}
