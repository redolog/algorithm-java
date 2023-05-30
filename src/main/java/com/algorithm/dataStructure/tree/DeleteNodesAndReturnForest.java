package com.algorithm.dataStructure.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/delete-nodes-and-return-forest/
 *
 * @author songhuilong001  @date 2023/5/30
 */
public class DeleteNodesAndReturnForest {

    Set<Integer> toDeleteSet;
    List<TreeNode> ans;

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        toDeleteSet = new HashSet<>();
        ans = new ArrayList<>();
        for (int val : toDelete) {
            toDeleteSet.add(val);
        }
        TreeNode rootRet = dfs(root);
        if (rootRet != null) {
            ans.add(rootRet);
        }
        return ans;
    }

    /**
     * @param node 当前节点
     * @return 使用返回值表达当前节点所在树的被删除结果
     */
    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            // 已经到了树底
            return null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        // 当前节点存活
        if (!toDeleteSet.contains(node.val)) {
            return node;
        }
        // 当前节点不能存活，靠他的左右子孙了
        if (node.left != null) {
            ans.add(node.left);
        }
        if (node.right != null) {
            ans.add(node.right);
        }
        // 当前节点+左右子都判断完了
        return null;
    }

}
