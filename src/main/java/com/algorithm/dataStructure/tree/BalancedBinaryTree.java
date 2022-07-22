package com.algorithm.dataStructure.tree;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * <p>
 * https://leetcode.cn/problems/balanced-binary-tree/
 *
 * @author dragonsong  @date 2022/7/22
 */
public class BalancedBinaryTree {

    static class DownToUp {
        /*
         * 从下往上算
         * h 函数负责计算当前节点高度
         * -1表示非平衡二叉树的高度，作为特判
         */

        /*
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 41.6 MB
         * , 在所有 Java 提交中击败了
         * 5.05%
         * 的用户
         * 通过测试用例：
         * 228 / 228
         */

        public boolean isBalanced(TreeNode root) {
            return h(root) != -1;
        }

        /**
         * 从下往上处理，即后序遍历，先处理左右子树，最后处理当前节点
         */
        private int h(TreeNode parent) {
            if (parent == null) {
                return 0;
            }
            int hLeft = h(parent.left);
            if (hLeft == -1) {
                return -1;
            }
            int hRight = h(parent.right);
            if (hRight == -1) {
                return -1;
            }
            if (Math.abs(hLeft - hRight) > 1) {
                return -1;
            }
            // 父节点高度为左右子树高度较大值+1
            return Math.max(hLeft, hRight) + 1;
        }
    }

    static class UpToDown {
        /*
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 45.18%
         * 的用户
         * 内存消耗：
         * 41.4 MB
         * , 在所有 Java 提交中击败了
         * 12.53%
         * 的用户
         * 通过测试用例：
         * 228 / 228
         */

        /**
         * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
         *
         * @return abs(h ( root.left)-h(root.right))<=1
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(depth(root.left, 0) - depth(root.right, 0)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int depth(TreeNode node, int h) {
            if (node == null) {
                return h;
            }
            return Math.max(depth(node.left, h + 1), depth(node.right, h + 1));
        }
    }

}
