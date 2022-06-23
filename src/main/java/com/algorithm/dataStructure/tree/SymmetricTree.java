package com.algorithm.dataStructure.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * @author dragonsong  @date 2022/6/23
 */
public class SymmetricTree {

    /**
     * 主要是要想到对称性可以同时在两棵树上同频移动
     */

    public boolean isSymmetricQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(right.left);
            queue.offer(left.right);
        }

        return true;
    }

    public boolean isSymmetricDfs(TreeNode root) {
        return dfs(root, root);
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 15.01%
     * 的用户
     * 通过测试用例：
     * 198 / 198
     */
    private boolean dfs(TreeNode l, TreeNode r) {
        if (l == null) {
            return r == null;
        }
        if (r == null) {
            return false;
        }
        return l.val == r.val && dfs(l.left, r.right) && dfs(l.right, r.left);
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 22.58%
     * 的用户
     * 内存消耗：
     * 41.1 MB
     * , 在所有 Java 提交中击败了
     * 5.04%
     * 的用户
     * 通过测试用例：
     * 198 / 198
     */
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            Deque<TreeNode> levelQueue = new LinkedList<>(queue);
            for (int i = 0; i < levelQueue.size(); i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
            int size = levelQueue.size();
            for (int i = 0; i < size / 2; i++) {
                TreeNode right = levelQueue.pollLast();
                TreeNode left = levelQueue.pollFirst();
                if (right == null && left == null) {
                    continue;
                }
                if (right == null || left == null) {
                    return false;
                }
                if (right.val != left.val) {
                    return false;
                }
            }
        }

        return true;
    }

}
