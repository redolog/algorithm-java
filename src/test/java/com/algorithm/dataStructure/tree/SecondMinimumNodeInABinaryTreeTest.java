package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecondMinimumNodeInABinaryTreeTest {

    @Test
    public void findSecondMinimumValue() {
        SecondMinimumNodeInABinaryTree service = new SecondMinimumNodeInABinaryTree();
        assertEquals(5, service.findSecondMinimumValue(TreeNode.buildAny(2, 2, 5, null, null, 5, 7)));
        assertEquals(-1, service.findSecondMinimumValue(TreeNode.buildAny(2, 2, 2)));
        assertEquals(2, service.findSecondMinimumValue(TreeNode.buildAny(1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1)));
        assertEquals(2147483647, service.findSecondMinimumValue(TreeNode.buildAny(2, 2, 2147483647)));
    }
}