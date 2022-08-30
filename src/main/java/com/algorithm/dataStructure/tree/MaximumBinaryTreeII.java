package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/maximum-binary-tree-ii/
 *
 * @author DragonSong  @date 2022/8/30
 */
public class MaximumBinaryTreeII {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                // 当前节点之后才可能有val的parent，一直右移
                parent = curr;
                curr = curr.right;
            } else {
                // 当前节点已经小于了val，父节点的right==val，val.left=curr
                TreeNode newNode = new TreeNode(val);
                parent.right = newNode;
                newNode.left = curr;
                break;
            }
        }
        if (curr == null) {
            parent.right = new TreeNode(val);
        }

        return root;
    }
}
