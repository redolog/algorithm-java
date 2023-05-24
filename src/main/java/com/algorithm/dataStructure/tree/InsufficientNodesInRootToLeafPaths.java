package com.algorithm.dataStructure.tree;

/**
 * <a href="https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/">1080. Insufficient Nodes in Root to Leaf Paths</a>
 *
 * @author songhuilong  @date 2023/5/24
 */
public class InsufficientNodesInRootToLeafPaths {

    public TreeNode sufficientSubset(TreeNode curr, int limit) {
        boolean insufficient = insufficient(curr, limit, 0);
        if (insufficient) {
            return null;
        }
        return curr;
    }

    /**
     * 被删除返回true
     */
    private boolean insufficient(TreeNode curr, int limit, int parentSum) {
        if (curr == null) {
            return true;
        }
        int currSum = parentSum + curr.val;
        if (curr.left == null && curr.right == null) {
            return currSum < limit;
        }
        boolean insufficientL = insufficient(curr.left, limit, currSum);
        if (insufficientL) {
            curr.left = null;
        }
        boolean insufficientR = insufficient(curr.right, limit, currSum);
        if (insufficientR) {
            curr.right = null;
        }
        return insufficientL && insufficientR;
    }

}
