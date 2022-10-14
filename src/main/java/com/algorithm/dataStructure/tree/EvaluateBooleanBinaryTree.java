package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/evaluate-boolean-binary-tree/
 *
 * @author songhuilong  @date 2022/10/14
 */
public class EvaluateBooleanBinaryTree {

    /**
     * 题干所给二叉树为一棵完整二叉树，子节点有0或者2个
     */
    public boolean evaluateTree(TreeNode root) {
        // 子为空时说明到底了，返回boolean
        if (root.left == null) {
            return root.val == 1;
        }
        return root.val == 2 ?
                // 2 or
                evaluateTree(root.left) || evaluateTree(root.right) :
                // 3 and
                evaluateTree(root.left) && evaluateTree(root.right);
    }
}
