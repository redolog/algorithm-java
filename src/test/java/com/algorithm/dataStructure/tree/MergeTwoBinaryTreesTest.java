package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeTwoBinaryTreesTest {

    MergeTwoBinaryTrees service = new MergeTwoBinaryTrees();

    @Test
    public void mergeTrees() {
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{3, 4, 5, 5, 4, null, 7}), service.mergeTrees(TreeNode.buildAnyWithArr(new Integer[]{1, 3, 2, 5}), TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3, null, 4, null, 7})));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{2, 2}), service.mergeTrees(TreeNode.buildAnyWithArr(new Integer[]{1}), TreeNode.buildAnyWithArr(new Integer[]{1, 2})));
    }
}