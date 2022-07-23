package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorOfABinaryTreeTest {

    @Test
    public void lowestCommonAncestor() {
        LowestCommonAncestorOfABinaryTree.DFS dfs = new LowestCommonAncestorOfABinaryTree.DFS();
        TreeNode root1 = TreeNode.buildAnyWithArr(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        assertEquals(3, dfs.lowestCommonAncestor(root1, node5, node1).val);
        TreeNode node4 = new TreeNode(4);
        assertEquals(5, dfs.lowestCommonAncestor(root1, node5, node4).val);
        TreeNode root2 = TreeNode.buildAnyWithArr(new Integer[]{1, 2});
        assertEquals(1, dfs.lowestCommonAncestor(root2, node1, node2).val);
    }
}