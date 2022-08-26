package com.algorithm.dataStructure.tree;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 *
 * @author dragonsong  @date 2022/8/27
 */
public class MaximumWidthOfBinaryTree {

    static class DFS {
        /**
         * dfs深度优先遍历，同样记录每个点的坐标，相比bfs，需要同时记录y轴即深度信息用于聚合
         * 需要借助额外的map来维护每一层的坐标信息，由于每一层最先进入的x坐标一定是最小的，因此只记录这第一个x值，用于后续计算距离用
         */

        int ans;
        /**
         * 每一层最小的x值
         */
        Map<Integer, Integer> y2MinX;

        public int widthOfBinaryTree(TreeNode root) {
            y2MinX = new HashMap<>();
            ans = 0;
            dfs(root, 1, 1);
            return ans;
        }

        private void dfs(TreeNode node, int x, int y) {
            if (node == null) {
                return;
            }
            y2MinX.putIfAbsent(y, x);
            ans = Math.max(ans, x - y2MinX.get(y) + 1);
            dfs(node.left, x * 2, y + 1);
            dfs(node.right, x * 2 + 1, y + 1);
        }
    }

    static class BFS {
        /**
         * 层序遍历
         * 时间复杂度：完整遍历一次树节点，O(n)
         * 空间复杂度：维护两个队列，O(n)
         */
        public int widthOfBinaryTree(TreeNode root) {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            Deque<Integer> coordinateQ = new ArrayDeque<>();
            coordinateQ.offer(1);

            int ans = 0;

            while (!q.isEmpty()) {
                // 这里直接相减，int溢出相减后依然在合法范围内
                // 如果在过程中维护min、max值，单个int值则会溢出，直接相减的做法很巧妙
                ans = Math.max(ans, coordinateQ.peekLast() - coordinateQ.peekFirst() + 1);
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.poll();
                    Integer x = coordinateQ.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                        coordinateQ.offer(2 * x);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                        coordinateQ.offer(2 * x + 1);
                    }
                }
            }
            return ans;
        }

        public int widthOfBinaryTree2(TreeNode root) {
            Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
            q.offer(new Pair<>(root, 1));

            int ans = 0;

            while (!q.isEmpty()) {
                ans = Math.max(ans, q.peekLast().getValue() - q.peekFirst().getValue() + 1);
                for (int i = q.size(); i > 0; i--) {
                    Pair<TreeNode, Integer> pair = q.poll();
                    TreeNode node = pair.getKey();
                    Integer x = pair.getValue();
                    if (node.left != null) {
                        q.offer(new Pair<>(node.left, 2 * x));
                    }
                    if (node.right != null) {
                        q.offer(new Pair<>(node.right, 2 * x + 1));
                    }
                }
            }
            return ans;
        }
    }


}
