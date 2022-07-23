package com.algorithm.dataStructure.tree;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * <p>
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author dragonsong  @date 2022/7/23
 */
public class LowestCommonAncestorOfABinaryTree {

    static class DFS {
        /*
         * 执行用时：
         * 6 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 42.8 MB
         * , 在所有 Java 提交中击败了
         * 37.95%
         * 的用户
         * 通过测试用例：
         * 31 / 31
         */

        /**
         * 同时去左右子树上匹配p、q
         * 1. root已经是某个节点，说明root就是两个节点的LCA；
         * 2. 左右子树均有匹配节点，说明公共祖先在root上；
         * 3. 只有左子树匹配到了p、q之一，说明右子树上没有p、q祖先；
         * 4. 只有右子树匹配到了p、q之一，说明左子树上没有p、q祖先；
         * <p>
         * 当然，如果题干给定可能无LCA的入参，那么左右子树的dfs戳到底，返回的就是null。
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p, q);
        }

        /**
         * 从root树上找p或者q，找到则返回对应节点
         * root树包含了：左右子树
         */
        private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                // 已经戳到底了
                return null;
            }
            // 当前遍历节点已经找到了
            if (root.val == p.val || root.val == q.val) {
                return root;
            }
            // 左子树是否有对应节点？
            TreeNode leftFound = dfs(root.left, p, q);
            // 右子树是否有对应节点？
            TreeNode rightFound = dfs(root.right, p, q);
            if (leftFound != null && rightFound != null) {
                // 左右子树均有匹配节点，说明公共祖先在root上
                return root;
            }
            if (leftFound != null) {
                // 只有左子树匹配到了p、q之一，说明右子树上没有p、q祖先
                return leftFound;
            }
            // 只有右子树匹配到了p、q之一，说明左子树上没有p、q祖先
            return rightFound;
        }
    }

}
