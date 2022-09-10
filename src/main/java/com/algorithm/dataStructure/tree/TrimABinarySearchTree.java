package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/trim-a-binary-search-tree/
 *
 * @author DragonSong  @date 2022/9/10
 */
public class TrimABinarySearchTree {

    static class Optimization {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (root.val < low) {
                return trimBST(root.right, low, high);
            }
            if (root.val > high) {
                return trimBST(root.left, low, high);
            }
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 根小于low，直接进入右子树
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 大于则进入左子树
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        dfs(root, low, high);
        return root;
    }

    private void dfs(TreeNode node, int low, int high) {
        if (null == node) {
            return;
        }
        // 以 3,0,4,null,2,null,null,1 为例，此处需消除掉0节点
        if (node.left != null && node.left.val < low) {
            node.left = trimBST(node.left, low, high);
        }
        if (node.right != null && node.right.val > high) {
            node.right = trimBST(node.right, low, high);
        }
        dfs(node.left, low, high);
        dfs(node.right, low, high);
    }
}
