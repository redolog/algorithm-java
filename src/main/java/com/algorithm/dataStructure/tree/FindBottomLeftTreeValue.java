package com.algorithm.dataStructure.tree;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 *
 * @author dragonsong  @date 2022/7/4
 */
public class FindBottomLeftTreeValue {

    static class BFS {

        /*
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 63.04%
         * 的用户
         * 内存消耗：
         * 40.8 MB
         * , 在所有 Java 提交中击败了
         * 82.06%
         * 的用户
         * 通过测试用例：
         * 76 / 76
         */

        /**
         * BFS，入队时左子节点后入队，保证最后处理的是最后一层的最左值
         */
        public int findBottomLeftValue(TreeNode root) {
            int ans = 0;
            Queue<TreeNode> q = new ArrayDeque<>();
            if (root != null) {
                q.offer(root);
            }
            while (!q.isEmpty()) {
                for (int size = q.size(); size > 0; size--) {
                    TreeNode node = q.poll();
                    ans = node.val;
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                }
            }
            return ans;
        }
    }

    static class DFS {
        /*
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 41.4 MB
         * , 在所有 Java 提交中击败了
         * 11.01%
         * 的用户
         * 通过测试用例：
         * 76 / 76
         */

        int maxDepth;

        int val;

        public int findBottomLeftValue(TreeNode root) {
            val = 0;
            maxDepth = 0;
            dfs(root, 0);
            return val;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                return;
            }
            depth++;
            if (maxDepth < depth) {
                maxDepth = depth;
            }
            if (depth == maxDepth) {
                val = node.val;
            }
            dfs(node.right, depth);
            dfs(node.left, depth);
        }
    }

}
