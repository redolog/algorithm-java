package com.algorithm.dataStructure.tree;


/**
 * 617. 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * https://leetcode.cn/problems/merge-two-binary-trees/
 *
 * @author dragonsong  @date 2022/7/4
 */
public class MergeTwoBinaryTrees {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 14.74%
     * 的用户
     * 通过测试用例：
     * 182 / 182
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode newRoot = new TreeNode(root1.val + root2.val);

        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }
}
