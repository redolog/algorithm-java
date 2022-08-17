package com.algorithm.dataStructure.tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/deepest-leaves-sum/
 *
 * @author dragonsong  @date 2022/8/17
 */
public class DeepestLeavesSum {

    static class DFS {
        Map<Integer, Integer> depth2Sum;
        int maxDepth;

        public int deepestLeavesSum(TreeNode root) {
            maxDepth = 0;
            depth2Sum = new HashMap<>();
            // root表示0深度
            dfs(root, 0);

            return depth2Sum.get(maxDepth);
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                return;
            }
            depth2Sum.put(depth, depth2Sum.getOrDefault(depth, 0) + node.val);
            maxDepth = Math.max(maxDepth, depth);
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }

    static class BFS {
        public int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> q = new ArrayDeque<>();
            int ans = 0;
            q.offer(root);

            while (!q.isEmpty()) {
                int sum = 0;
                for (int i = q.size(); i > 0; i--) {
                    TreeNode curr = q.poll();
                    sum += curr.val;
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                ans = sum;
            }

            return ans;
        }
    }
}
