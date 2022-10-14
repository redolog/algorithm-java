package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EvaluateBooleanBinaryTreeTest {

    @Test
    public void evaluateTree() {
        EvaluateBooleanBinaryTree service = new EvaluateBooleanBinaryTree();
        assertTrue(service.evaluateTree(TreeNode.buildAny(2, 1, 3, null, null, 0, 1)));
        assertFalse(service.evaluateTree(TreeNode.buildAny(0)));
    }
}