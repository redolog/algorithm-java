package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumWidthOfBinaryTreeTest {

    @Test
    public void widthOfBinaryTree() {
        MaximumWidthOfBinaryTree.BFS bfs = new MaximumWidthOfBinaryTree.BFS();
        assertEquals(4, bfs.widthOfBinaryTree(TreeNode.buildAny(1, 3, 2, 5, 3, null, 9)));
        assertEquals(7, bfs.widthOfBinaryTree(TreeNode.buildAny(1, 3, 2, 5, null, null, 9, 6, null, 7)));
        assertEquals(2, bfs.widthOfBinaryTree(TreeNode.buildAny(1, 3, 2, 5)));
        assertEquals(2147483645, bfs.widthOfBinaryTree(TreeNode.buildAny(1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null)));
        assertEquals(4, bfs.widthOfBinaryTree2(TreeNode.buildAny(1, 3, 2, 5, 3, null, 9)));
        assertEquals(7, bfs.widthOfBinaryTree2(TreeNode.buildAny(1, 3, 2, 5, null, null, 9, 6, null, 7)));
        assertEquals(2, bfs.widthOfBinaryTree2(TreeNode.buildAny(1, 3, 2, 5)));
        assertEquals(2147483645, bfs.widthOfBinaryTree2(TreeNode.buildAny(1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null)));

        MaximumWidthOfBinaryTree.DFS dfs = new MaximumWidthOfBinaryTree.DFS();
        assertEquals(4, dfs.widthOfBinaryTree(TreeNode.buildAny(1, 3, 2, 5, 3, null, 9)));
        assertEquals(7, dfs.widthOfBinaryTree(TreeNode.buildAny(1, 3, 2, 5, null, null, 9, 6, null, 7)));
        assertEquals(2, dfs.widthOfBinaryTree(TreeNode.buildAny(1, 3, 2, 5)));
        assertEquals(2147483645, dfs.widthOfBinaryTree(TreeNode.buildAny(1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null)));
    }
}