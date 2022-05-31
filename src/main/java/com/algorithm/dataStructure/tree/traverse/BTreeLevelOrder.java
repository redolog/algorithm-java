package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.LinkedList;

/**
 * 按层遍历二叉树
 *
 * @author dragonsong  @date 2022/5/30
 */
public class BTreeLevelOrder {

    /**
     * BFS，广度优先：按层遍历：一层-> 二层-> 三层-> 最下层
     *
     * @param node 当前节点
     */
    public static void levelOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode qnode = queue.poll();
            if (qnode == null) {
                continue;
            }
            System.out.println(qnode.val);
            if (qnode.left != null) {
                queue.offer(qnode.left);
            }
            if (qnode.right != null) {
                queue.offer(qnode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);

        TreeNode three = new TreeNode(3, six, null);
        TreeNode two = new TreeNode(2, four, five);

        TreeNode one = new TreeNode(1, two, three);

        levelOrderTraverse(one);
    }


}
