package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrimABinarySearchTreeTest {

    @Test
    public void trimBST() {
        TrimABinarySearchTree service = new TrimABinarySearchTree();
        assertEquals(TreeNode.buildAny(1, null, 2), service.trimBST(TreeNode.buildAny(1, 0, 2), 1, 2));
        assertEquals(TreeNode.buildAny(3, 2, null, 1), service.trimBST(TreeNode.buildAny(3, 0, 4, null, 2, null, null, 1), 1, 3));
        TrimABinarySearchTree.Optimization optimization = new TrimABinarySearchTree.Optimization();
        assertEquals(TreeNode.buildAny(1, null, 2), optimization.trimBST(TreeNode.buildAny(1, 0, 2), 1, 2));
        assertEquals(TreeNode.buildAny(3, 2, null, 1), optimization.trimBST(TreeNode.buildAny(3, 0, 4, null, 2, null, null, 1), 1, 3));
    }
}