package com.algorithm.dataStructure.tree.cousin;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/cousins-in-binary-tree-ii/
 *
 * @author songhuilong001  @date 2023/4/16
 */
public class CousinsInBinaryTreeII {

    static class DFSSolultion {
        Map<Integer, Integer> level2Sum = new HashMap<>();
        // key为父节点node坐标
        Map<TreeNode, Integer> parent2ChildrenSum = new HashMap<>();

        public TreeNode replaceValueInTree(TreeNode root) {
            // 先记录每层的和、父节点两子和
            // 第二次遍历时，走到三层以下（包含）时，当前节点值=层和-父节点两子和
            level2Sum = new HashMap<>();
            parent2ChildrenSum = new HashMap<>();
            record(root, 1);
            replace(root, 1, null);
            return root;
        }

        private void replace(TreeNode node, int y, TreeNode parent) {
            if (node == null) {
                return;
            }
            if (y >= 3) {
                node.val = level2Sum.get(y) - parent2ChildrenSum.getOrDefault(parent, 0);
            } else {
                node.val = 0;
            }
            replace(node.left, y + 1, node);
            replace(node.right, y + 1, node);
        }

        private void record(TreeNode node, int y) {
            if (node == null) {
                return;
            }
            level2Sum.put(y, level2Sum.getOrDefault(y, 0) + node.val);
            parent2ChildrenSum.put(node, sumChildren(node));
            record(node.left, y + 1);
            record(node.right, y + 1);
        }

        private int sumChildren(TreeNode parent) {
            int sum = 0;
            if (parent.left != null) {
                sum += parent.left.val;
            }
            if (parent.right != null) {
                sum += parent.right.val;
            }
            return sum;
        }
    }

    static class LevelOrderSolution {
        public TreeNode replaceValueInTree(TreeNode root) {
            Deque<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            root.val = 0;
            while (!q.isEmpty()) {
                // 层序，每层处理下一层的节点
                // 下一层节点值 = 下一层总和 - 当前节点子节点和
                // 下一层总和

                // 使用快照list遍历求和，不改变原节点数据
                List<TreeNode> levelNodes = new ArrayList<>(q);
                int childLevelSum = 0;

                // 清空队列本层
                q.clear();
                for (TreeNode curr : levelNodes) {
                    if (curr.left != null) {
                        q.offer(curr.left);
                        childLevelSum += curr.left.val;
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                        childLevelSum += curr.right.val;
                    }
                }

                for (TreeNode curr : levelNodes) {
                    // 由于下面可能会修改left+right的值，所以子和必须这里统一求出
                    int childrenSum = childrenSum(curr);
                    if (curr.left != null) {
                        curr.left.val = childLevelSum - childrenSum;
                    }
                    if (curr.right != null) {
                        curr.right.val = childLevelSum - childrenSum;
                    }
                }
            }

            return root;
        }

        private int childrenSum(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int sum = 0;
            if (node.left != null) {
                sum += node.left.val;
            }
            if (node.right != null) {
                sum += node.right.val;
            }
            return sum;
        }
    }

}
