package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumBinaryTreeTest {

    @Test
    public void constructMaximumBinaryTree() {
        MaximumBinaryTree.Recursion recursion = new MaximumBinaryTree.Recursion();
        assertEquals(TreeNode.buildAny(6, 3, 5, null, 2, 0, null, null, 1), recursion.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
        assertEquals(TreeNode.buildAny(3, null, 2, null, 1), recursion.constructMaximumBinaryTree(new int[]{3, 2, 1}));

        MaximumBinaryTree.MonotonousDecreaseStack monotonousDecreaseStack = new MaximumBinaryTree.MonotonousDecreaseStack();
        assertEquals(TreeNode.buildAny(6, 3, 5, null, 2, 0, null, null, 1), monotonousDecreaseStack.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
        assertEquals(TreeNode.buildAny(3, null, 2, null, 1), monotonousDecreaseStack.constructMaximumBinaryTree(new int[]{3, 2, 1}));
    }
}