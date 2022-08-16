package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiameterOfBinaryTreeTest {

    @Test
    public void diameterOfBinaryTree() {
        DiameterOfBinaryTree service = new DiameterOfBinaryTree();
        assertEquals(3, service.diameterOfBinaryTree(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5})));
        assertEquals(1, service.diameterOfBinaryTree(TreeNode.buildAnyWithArr(new Integer[]{1, 2})));
        assertEquals(8, service.diameterOfBinaryTree(TreeNode.buildAnyWithArr(new Integer[]{4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2})));
    }
}