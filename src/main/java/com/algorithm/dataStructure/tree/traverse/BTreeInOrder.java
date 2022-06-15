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
     * 二叉树中序遍历
     */
    public static void inOrderStack(TreeNode node) {
        // 使用栈结构存储调用链路
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || node != null) {
            // node遍历到有值的节点，入栈，同时挪动到其左子节点，直至到最左子节点
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 已到达最左节点，开始从栈中取出遍历过的节点
            node = stack.pop();
            // 处理当前节点
            System.out.println(node.val);
            // 向右侧挪动，如果没有右子节点，下一步循环会持续从栈中出栈元素，一步步退回到root节点后，开始遍历root的右子树
            node = node.right;
        }
    }
}
