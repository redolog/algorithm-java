package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 *
 * @author songhuilong  @date 2022/11/30
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode cloned, final TreeNode target) {
        return dfs(cloned, target);
    }

    private TreeNode dfs(TreeNode cloned, TreeNode target) {
        if (cloned == null || cloned.val == target.val) {
            return cloned;
        }
        TreeNode left = dfs(cloned.left, target);
        if (left != null) {
            return left;
        }
        return dfs(cloned.right, target);
    }
}
