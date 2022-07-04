package com.algorithm.dataStructure.tree;


/**
 * 404. 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * https://leetcode.cn/problems/sum-of-left-leaves/
 *
 * @author dragonsong  @date 2022/7/4
 */
public class SumOfLeftLeaves {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 44.57%
     * 的用户
     * 通过测试用例：
     * 100 / 100
     */

    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int i) {
        if (node == null) {
            return 0;
        }
        return ((i & 1) == 1 && node.left == null && node.right == null ? node.val : 0) + sum(node.left, 2 * i + 1) + sum(node.right, 2 * i + 2);
    }

}
