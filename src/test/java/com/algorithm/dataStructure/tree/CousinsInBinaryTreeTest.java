package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CousinsInBinaryTreeTest {

    @Test
    public void isCousins() {
        CousinsInBinaryTree service = new CousinsInBinaryTree();
        assertTrue(service.isCousins(TreeNode.buildAny(1, 2, 3, null, 4, null, 5), 5, 4));
        assertFalse(service.isCousins(TreeNode.buildAny(1, 2, 3, null, 4), 2, 3));
        assertFalse(service.isCousins(TreeNode.buildAny(1, 2, 3, 4), 4, 3));
    }
}