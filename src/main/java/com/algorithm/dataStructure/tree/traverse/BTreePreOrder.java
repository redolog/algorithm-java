package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BTreePreOrder {

    /**
     * 先序遍历：本节点->左子树->右子树
     *
     * @param node 当前节点
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);

        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public static void preOrderStack(TreeNode node) {
        if (node == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(node);

        TreeNode curr;
        while ((curr = stack.pop()) != null) {
            System.out.println(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }
}
