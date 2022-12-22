package com.algorithm.dataStructure.tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 *
 * @author songhuilong  @date 2022/12/22
 */
public class MaximumLevelSumOfABinaryTree {

    static class BFS {
        // 层序遍历
        public int maxLevelSum(TreeNode root) {
            int maxSum = root.val, ans = 1, level = 1;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int levelSize = q.size(), levelSum = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode curr = q.poll();
                    levelSum += curr.val;
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                if (levelSum > maxSum) {
                    maxSum = levelSum;
                    ans = level;
                }
                level++;
            }
            return ans;
        }
    }

    static class DFS {
        Map<Integer, Integer> level2Sum;

        public int maxLevelSum(TreeNode root) {
            level2Sum = new LinkedHashMap<>();
            dfs(root, 1);

            int maxSum = level2Sum.values().stream().max(Comparator.naturalOrder()).orElse(-1);
            for (Map.Entry<Integer, Integer> entry : level2Sum.entrySet()) {
                if (entry.getValue() == maxSum) {
                    return entry.getKey();
                }
            }
            return -1;
        }

        private void dfs(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            int levelSum = level2Sum.getOrDefault(level, 0) + node.val;
            level2Sum.put(level, levelSum);
            dfs(node.left, level + 1);
            dfs(node.right, level + 1);
        }
    }

}
