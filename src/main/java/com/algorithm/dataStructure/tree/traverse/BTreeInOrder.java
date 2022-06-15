package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BTreeInOrder {

    /**
     * 中序遍历：左子树-> 当前节点-> 右子树
     *
     * @param node 当前节点
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);

        System.out.println(node.val);

        inOrderTraverse(node.right);
    }

    /**
     * 整个左边界依次入栈
     */
    public static void inOrderStack(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
        }
    }
}
