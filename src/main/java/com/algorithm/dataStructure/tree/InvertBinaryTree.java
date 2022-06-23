package com.algorithm.dataStructure.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * https://leetcode.cn/problems/invert-binary-tree/
 *
 * @author dragonsong  @date 2022/6/23
 */
public class InvertBinaryTree {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 45.72%
     * 的用户
     * 通过测试用例：
     * 77 / 77
     */
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode right = node.right;
        node.right = node.left;
        node.left = right;
        reverse(node.left);
        reverse(node.right);
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 5.29%
     * 的用户
     * 通过测试用例：
     * 77 / 77
     */
    public TreeNode invertTreeBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);

                TreeNode leftTmp = node.left;
                node.left = node.right;
                node.right = leftTmp;
            }
        }

        return root;
    }

}
