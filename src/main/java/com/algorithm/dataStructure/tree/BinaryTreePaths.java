package com.algorithm.dataStructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：["1"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/binary-tree-paths/
 *
 * @author dragonsong  @date 2022/8/1
 */
public class BinaryTreePaths {

    static class BFS {
        /*
         * 执行用时：
         * 9 ms
         * , 在所有 Java 提交中击败了
         * 15.00%
         * 的用户
         * 内存消耗：
         * 41.7 MB
         * , 在所有 Java 提交中击败了
         * 39.38%
         * 的用户
         * 通过测试用例：
         * 208 / 208
         */

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();

            Queue<TreeNode> queue = new ArrayDeque<>();
            Queue<String> pathQ = new ArrayDeque<>();
            if (root != null) {
                queue.offer(root);
                pathQ.offer("" + root.val);
            }
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                String path = pathQ.poll();
                if (node.left == null && node.right == null) {
                    ans.add(path);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    pathQ.offer(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    pathQ.offer(path + "->" + node.right.val);
                }
            }

            return ans;
        }
    }

    static class DFS {
        /*
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 99.97%
         * 的用户
         * 内存消耗：
         * 40.3 MB
         * , 在所有 Java 提交中击败了
         * 99.14%
         * 的用户
         * 通过测试用例：
         * 208 / 208
         */

        List<String> ans;

        StringBuilder builder;

        public List<String> binaryTreePaths(TreeNode root) {
            ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            builder = new StringBuilder();
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode node) {
            builder.append(node.val);
            if (node.left == null && node.right == null) {
                ans.add(builder.toString());
                return;
            }

            if (node.left != null) {
                builder.append("->");
                dfs(node.left);
                if (builder.indexOf("->") != -1) {
                    builder.delete(builder.lastIndexOf("->"), builder.length());
                }
            }
            if (node.right != null) {
                builder.append("->");
                dfs(node.right);
                if (builder.indexOf("->") != -1) {
                    builder.delete(builder.lastIndexOf("->"), builder.length());
                }
            }
        }
    }

}
