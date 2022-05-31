package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

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
}
