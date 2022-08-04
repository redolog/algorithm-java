package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. 二叉树的完全性检验
 * 给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。
 * <p>
 * 在一个 完全二叉树 中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含 1 到 2h 节点之间的最后一级 h 。
 * <p>
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 *
 * @author dragonsong  @date 2022/6/14
 */
public class CheckCompletenessOfABst {

    /**
     * 下标指针，左子 i=2*parentI+1 右子 i=2*parentI+2
     */
    int maxIdx;
    /**
     * 遍历指针，从0开始计数
     */
    int n;

    /**
     * dfs深度优先遍历，判断遍历数n与最后节点的下标是否满足 完全二叉树定义
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.1 MB
     * , 在所有 Java 提交中击败了
     * 14.91%
     * 的用户
     * 通过测试用例：
     * 119 / 119
     */
    public boolean isCompleteTreeWithDfs(TreeNode root) {
        dfs(root, 0);
        return n - 1 == maxIdx;
    }

    /**
     * dfs深度优先遍历
     *
     * @param node    当前节点
     * @param parentI 父节点下标
     */
    private void dfs(TreeNode node, int parentI) {
        if (null == node) {
            return;
        }

        maxIdx = Math.max(maxIdx, parentI);
        ++n;

        dfs(node.left, 2 * parentI + 1);
        dfs(node.right, 2 * parentI + 2);
    }

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 65.86%
     * 的用户
     * 内存消耗：
     * 40.6 MB
     * , 在所有 Java 提交中击败了
     * 80.89%
     * 的用户
     * 通过测试用例：
     * 119 / 119
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        // 一轮中如果出现先有null再有非null，即出现了非完全的情况
        boolean hasNull = false;
        while (!level.isEmpty()) {
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = level.poll();
                if (node == null) {
                    hasNull = true;
                    continue;
                }
                // 到这里肯定不为null
                if (hasNull) {
                    return false;
                }
                level.offer(node.left);
                level.offer(node.right);
            }
        }
        return true;
    }
}
