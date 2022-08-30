package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumBinaryTreeIITest {

    @Test
    public void testInsertIntoMaxTree() {
        MaximumBinaryTreeII service = new MaximumBinaryTreeII();
        assertEquals(TreeNode.buildAny(5, 4, null, 1, 3, null, null, 2), service.insertIntoMaxTree(TreeNode.buildAny(4, 1, 3, null, null, 2), 5));
        assertEquals(TreeNode.buildAny(5, 2, 4, null, 1, null, 3), service.insertIntoMaxTree(TreeNode.buildAny(5, 2, 4, null, 1), 3));
        assertEquals(TreeNode.buildAny(5, 2, 4, null, 1, 3), service.insertIntoMaxTree(TreeNode.buildAny(5, 2, 3, null, 1), 4));
    }
}