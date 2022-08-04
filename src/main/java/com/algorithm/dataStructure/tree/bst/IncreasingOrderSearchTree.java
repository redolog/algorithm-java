package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * <p>
 * https://leetcode.cn/problems/increasing-order-search-tree/
 *
 * @author dragonsong  @date 2022/8/4
 */
public class IncreasingOrderSearchTree {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.4 MB
     * , 在所有 Java 提交中击败了
     * 11.37%
     * 的用户
     * 通过测试用例：
     * 38 / 38
     */

    TreeNode ans;

    TreeNode prev;

    public TreeNode increasingBST(TreeNode root) {
        ans = null;
        prev = null;
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            if (prev != null) {
                prev.left = null;
            }
            return;
        }

        inOrder(node.left);
        // 中序操作
        if (ans == null) {
            ans = node;
        }
        if (prev != null) {
            prev.right = node;
            prev.left = null;
        }
        prev = node;
        inOrder(node.right);
    }
}
