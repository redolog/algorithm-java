package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.LinkedList;

/**
 * 按层遍历二叉树
 *
 * @author dragonsong  @date 2022/5/30
 */
public class BTreeLevelOrder {

    private static LinkedList<TreeNode> QUEUE = new LinkedList<>();

    /**
     * BFS，广度优先：按层遍历：一层-> 二层-> 三层-> 最下层
     *
     * @param node 当前节点
     */
    public static void levelOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        QUEUE.offer(node);

        while (!QUEUE.isEmpty()) {
            TreeNode qnode = QUEUE.poll();
            if (qnode == null) {
                continue;
            }
            System.out.println(qnode.val);
            if (qnode.left != null) {
                QUEUE.offer(qnode.left);
            }
            if (qnode.right != null) {
                QUEUE.offer(qnode.right);
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
