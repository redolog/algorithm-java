package com.algorithm.dataStructure.tree;

/**
 * 543. Diameter of Binary Tree
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 * <p>
 * Input: root = [1,2]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 *
 * @author dragonsong  @date 2022/8/16
 */
public class DiameterOfBinaryTree {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        d(root);
        return ans;
    }

    /**
     * dfs 求深度
     */
    private int d(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = d(node.left);
        int r = d(node.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }
}
