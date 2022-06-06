package com.algorithm.dataStructure.tree;

// @formatter:off
/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * @author dragonsong  @date 2022/6/6
 */
// @formatter:on
public class MaxDepthOfBinaryTree {

    /**
     * 递推公式：f(n)=max(f(n.left),f(n.right))+1
     * 边界条件：当前处理节点为null时，高度为0，深度为最大
     * <p>
     * 回溯时：null上级节点深度+1，继续回溯，每一层+1
     *
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
