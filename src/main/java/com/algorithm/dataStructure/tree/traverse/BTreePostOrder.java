package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

public class BTreePostOrder {

    /**
     * 后序遍历：左子树-> 右子树 -> 当前节点
     * @param node 当前节点
     */
    public static void postOrderTraverse(TreeNode node){
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);

        System.out.println(node.val);
    }
}
