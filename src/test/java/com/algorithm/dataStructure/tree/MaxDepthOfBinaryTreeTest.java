package com.algorithm.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class MaxDepthOfBinaryTreeTest {

    @Test
    public void maxDepth() {
        Assert.assertEquals(3,
                MaxDepthOfBinaryTree.maxDepth(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}