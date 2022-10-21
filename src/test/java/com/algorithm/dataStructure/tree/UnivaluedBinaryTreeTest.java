package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnivaluedBinaryTreeTest {

    @Test
    public void isUnivalTree() {
        UnivaluedBinaryTree service = new UnivaluedBinaryTree();
        assertTrue(service.isUnivalTree(TreeNode.buildAny(1, 1, 1, 1, 1, null, 1)));
        assertFalse(service.isUnivalTree(TreeNode.buildAny(2, 2, 2, 5, 2)));
    }
}