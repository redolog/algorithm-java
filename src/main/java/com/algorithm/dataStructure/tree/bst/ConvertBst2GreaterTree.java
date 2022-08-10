package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * <p>
 * <p>
 * <p>
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 *
 * @author dragonsong  @date 2022/7/4
 */
public class ConvertBst2GreaterTree {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 34.13%
     * 的用户
     * 通过测试用例：
     * 215 / 215
     */

    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        return inOrder(root);
    }

    private TreeNode inOrder(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.right = inOrder(node.right);

        sum += node.val;
        root.val = sum;

        root.left = inOrder(node.left);
        return root;
    }
}
