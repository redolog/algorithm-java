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
    Set<TreeNode> rootSet;

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        toDeleteSet = new HashSet<>();
        rootSet = new HashSet<>();
        for (int val : toDelete) {
            toDeleteSet.add(val);
        }
        dfs(root, null, null);
        return new ArrayList<>(rootSet);
    }

    private void dfs(TreeNode node, TreeNode root, TreeNode curr) {
        if (node == null) {
            addRoot(root);
            return;
        }
        if (toDeleteSet.contains(node.val)) {
            dfs(node.left, null, null);
            dfs(node.right, null, null);
        } else {
            if (root == null) {
                root = new TreeNode(node.val);
                curr = root;
            }
            if (node.left != null && !toDeleteSet.contains(node.left.val)) {
                curr.left = new TreeNode(node.left.val);
            }
            if (node.right != null && !toDeleteSet.contains(node.right.val)) {
                curr.right = new TreeNode(node.right.val);
            }
            if (node.left != null && node.right != null && toDeleteSet.contains(node.left.val) && toDeleteSet.contains(node.right.val)) {
                addRoot(root);
            }

            dfs(node.left, root, curr.left);
            dfs(node.right, root, curr.right);
        }
    }

    private void addRoot(TreeNode root) {
        if (root != null) {
            rootSet.add(root);
        }
    }

}
