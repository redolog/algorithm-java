package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumLevelSumOfABinaryTreeTest {

    @Test
    public void maxLevelSum() {
        MaximumLevelSumOfABinaryTree.DFS dfs = new MaximumLevelSumOfABinaryTree.DFS();
        assertEquals(2, dfs.maxLevelSum(TreeNode.buildAny(1, 7, 0, 7, -8, null, null)));
        assertEquals(2, dfs.maxLevelSum(TreeNode.buildAny(989, null, 10250, 98693, -89388, null, null, null, -32127)));
        MaximumLevelSumOfABinaryTree.BFS bfs = new MaximumLevelSumOfABinaryTree.BFS();
        assertEquals(2, bfs.maxLevelSum(TreeNode.buildAny(1, 7, 0, 7, -8, null, null)));
        assertEquals(2, bfs.maxLevelSum(TreeNode.buildAny(989, null, 10250, 98693, -89388, null, null, null, -32127)));
    }
}