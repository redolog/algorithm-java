package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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


    public static void postOrderStack(TreeNode node){
        if (node == null) {
            return;
        }
        // 使用 traverseStack 遍历树节点
        Deque<TreeNode> traverseStack=new LinkedList<>();
        traverseStack.push(node);
        // executeStack 倒序记录执行顺序
        // 执行顺序 左右本，与压栈顺序相反
        Deque<TreeNode> executeStack=new LinkedList<>();

        while (!traverseStack.isEmpty()) {
            TreeNode curr = traverseStack.pop();
            // 本
            executeStack.push(curr);
            // 左
            if (curr.left != null) {
                traverseStack.push(curr.left);
            }
            // 右
            if (curr.right != null) {
                traverseStack.push(curr.right);
            }
        }
        // executeStack 执行顺序：
        while (!executeStack.isEmpty()) {
            System.out.println(executeStack.pop().val);
        }
    }
}
