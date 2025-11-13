package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/
 *
 * @author songhuilong  @date 2023/2/23
 */
public class SecondMinimumNodeInABinaryTree {

    // 算法概述：对树进行完整遍历，维护根节点值（树最小值），查找剩余元素中大于根值且最小的值，即为第二小的值

    // 根节点值
    int rootVal;
    // 更新答案
    int ans;

    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        ans = -1;

        dfs(root);

        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // 任意遍历顺序，只需要完整一次树即可
        dfs(node.left);
        dfs(node.right);

        if (node.val > rootVal) {
            // 在大于根节点值的范围中筛选
            // 1. ans值初始的情况，直接更新；
            // 2. ans值非初始的情况，取相对更新过的值更小的值；
            ans = ans == -1 ? node.val : Math.min(ans, node.val);
        }
    }
}
