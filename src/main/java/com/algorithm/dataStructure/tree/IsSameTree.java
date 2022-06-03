package com.algorithm.dataStructure.tree;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 * <p>
 * <p>
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 * <p>
 * https://leetcode.cn/problems/same-tree/
 *
 * @author dragonsong  @date 2022/6/4
 */
public class IsSameTree {

    /**
     * 两棵树一致的判定：每层的对应次序的节点val一致
     * 入参为两个node，我们先判断本层本节点val值是否相同，所以对应一个解：p.val == q.val
     * 同时，同步遍历两棵树，我们假设有n层，那么解设为f，那么f(n)=p.val == q.val && f(n-1)
     * 其中f(n-1)=f(n.right)+f(n.left)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
