package com.algorithm.dataStructure.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * https://leetcode.cn/problems/validate-binary-search-tree/
 *
 * @author dragonsong  @date 2022/6/15
 */
public class IsValidBst {

    long preVal = Long.MIN_VALUE;

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41 MB
     * , 在所有 Java 提交中击败了
     * 48.66%
     * 的用户
     * 通过测试用例：
     * 80 / 80
     */
    public boolean isValidBSTInOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean validLeft = isValidBSTInOrder(root.left);
        if (!validLeft) {
            return false;
        }
        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        return isValidBSTInOrder(root.right);
    }

    public boolean isValidBSTInOrderWithStack(TreeNode node) {
        long preVal = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (preVal >= node.val) {
                return false;
            }

            preVal = node.val;
            node = node.right;
        }
        return true;
    }

    public boolean isValidBSTWithRange(TreeNode root) {
        return isValidBSTWithRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 检查bst节点值是否在开区间内
     *
     * @param node     当前节点
     * @param minValue 左开区间
     * @param maxValue 右开区间
     */
    private boolean isValidBSTWithRange(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (val <= minValue || val >= maxValue) {
            return false;
        }
        return isValidBSTWithRange(node.left, minValue, val) && isValidBSTWithRange(node.right, val, maxValue);
    }


}
