package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 *
 * @author songhuilong  @date 2025/11/27
 */
public class FlattenBinaryTreeToLinkedList {


    TreeNode pre;

    public void flatten(TreeNode curr) {
        dfs(curr);
    }

    // dfs返回当前子树展开后的尾节点
    private TreeNode dfs(TreeNode curr) {
        if (curr == null) {
            return null;
        }
        TreeNode leftTail = dfs(curr.left);
        TreeNode rightTail = dfs(curr.right);
        if (leftTail != null) {
            leftTail.right = curr.right;
            curr.right = curr.left;
            curr.left = null;
        }

        if (rightTail != null) {
            return rightTail;
        }
        if (leftTail != null) {
            return leftTail;
        }
        return curr;
    }

    private void preOrder(TreeNode curr) {
        if (curr == null) {
            return;
        }
        TreeNode left = curr.left;
        TreeNode right = curr.right;

        if (pre != null) {
            pre.left = null;
            pre.right = curr;

        }
        pre = curr;

        preOrder(left);
        preOrder(right);

    }

    private void afterOrder(TreeNode curr) {
        if (curr == null) {
            return;
        }

        afterOrder(curr.right);
        afterOrder(curr.left);

        curr.left = null;
        curr.right = pre;
        pre = curr;

    }
}
