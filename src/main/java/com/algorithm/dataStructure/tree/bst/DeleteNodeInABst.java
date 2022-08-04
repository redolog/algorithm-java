package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 * <p>
 * <p>
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 *
 * @author dragonsong  @date 2022/6/13
 */
public class DeleteNodeInABst {

    /**
     * 优化递归调用栈带来的空间开销，通过遍历来解决
     */
    public TreeNode deleteNodeTraversal(TreeNode root, int val) {
        // todo
        return null;
    }

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 42 MB
     * , 在所有 Java 提交中击败了
     * 8.44%
     * 的用户
     * 通过测试用例：
     * 91 / 91
     */

    /**
     * 判断val位置：
     * 1. 左子树上，递归到左子树；
     * 2. 右子树上，递归到右子树；
     * 3. 找到了待删节点：
     * - 判断是否只有一个子节点，如果是，直接用另一边的子树节点顶上；
     * - 如果不是，找到右子树最小节点，替换到当前节点位置，并删除；
     * - 1962年，Hibbard 提出，Hibbard Deletion算法
     *
     * @param root 当前树根
     * @param val  待删除节点
     * @return 删除之后的整树根
     */
    public TreeNode deleteNodeRecursion(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            root.left = deleteNodeRecursion(root.left, val);
            return root;
        } else if (root.val < val) {
            root.right = deleteNodeRecursion(root.right, val);
            return root;
        } else {
            // val==node.val
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 左右子节点均存在，将右子树中最小节点删除，同时将右子树最小节点替换到当前node位置
            TreeNode miniNode = findMiniNode(root.right);
            miniNode.right = removeMini(root.right);
            miniNode.left = root.left;
            return miniNode;
        }
    }

    // 返回当前node树上的最小节点
    public TreeNode findMiniNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return findMiniNode(node.left);
    }

    // 返回删除当前树最小节点后的根
    public TreeNode removeMini(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMini(node.left);
        return node;
    }
}
