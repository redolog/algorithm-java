package com.algorithm.dataStructure.tree.bst;


import com.algorithm.dataStructure.tree.TreeNode;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 *
 * @author songhuilong  @date 2025/11/12
 */
public class KthSmallestElementInABST {

    // 算法概述：求bst中k最小或最k最大元素，只需中序遍历（升序 | 降序），对回溯次数进行计数，到达k次时，即为对应k最小或k最大元素

    // 回溯次数
    int cnt;
    // 更新答案值
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        ans = -1;

        dfs(root, k);

        return ans;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        // 中序升序遍历
        dfs(node.left, k);

        cnt++;
        if (cnt == k) {
            ans = node.val;
            return;
        }

        dfs(node.right, k);
    }
}
