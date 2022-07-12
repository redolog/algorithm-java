package com.algorithm.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * <p>
 * https://leetcode.cn/problems/increasing-order-search-tree/
 *
 * @author dragonsong  @date 2022/7/12
 */
public class IncreasingOrderSearchTree {

    static class ListSolution {
        List<TreeNode> increasingList;

        public TreeNode increasingBST(TreeNode root) {
            increasingList = new ArrayList<>();
            inOrder(root);

            TreeNode dummy = new TreeNode();

            TreeNode curr = dummy;
            for (TreeNode node : increasingList) {
                curr.right = node;
                curr = node;
            }

            return dummy.right;
        }

        public void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }

            inOrder(node.left);

            increasingList.add(node);

            inOrder(node.right);
        }
    }

    static class Recursion {
        TreeNode dummy;

        TreeNode prev;

        public TreeNode increasingBST(TreeNode root) {
            dummy = new TreeNode();
            prev = dummy;
            inOrder(root);
            return dummy.right;
        }

        public void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }

            inOrder(node.left);

            if (dummy.right == null) {
                dummy.right = node;
            }

            node.left = null;
            prev.right = node;
            prev = node;

            inOrder(node.right);

        }
    }


}
