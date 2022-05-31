package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

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
}
