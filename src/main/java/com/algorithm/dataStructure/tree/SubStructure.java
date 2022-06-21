package com.algorithm.dataStructure.tree;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * <p>
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 *
 * @author dragonsong  @date 2022/6/21
 */
public class SubStructure {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 44.1 MB
     * , 在所有 Java 提交中击败了
     * 5.16%
     * 的用户
     * 通过测试用例：
     * 48 / 48
     */
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (b == null || a == null) {
            return false;
        }
        return dfs(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    public boolean dfs(TreeNode a, TreeNode b) {
        if (a == null) {
            return b == null;
        }
        // 递归逻辑与sameTree的区别
        if (b == null) {
            return true;
        }
        return a.val == b.val && dfs(a.left, b.left) && dfs(a.right, b.right);
    }

}
