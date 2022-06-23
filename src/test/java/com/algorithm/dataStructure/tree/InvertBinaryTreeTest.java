package com.algorithm.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class InvertBinaryTreeTest {

    InvertBinaryTree service = new InvertBinaryTree();

    @Test
    public void invertTree() {

        Assert.assertEquals(TreeNode.buildAnyWithArr(new Integer[]{4, 7, 2, 9, 6, 3, 1}), service.invertTree(TreeNode.buildAnyWithArr(new Integer[]{4, 2, 7, 1, 3, 6, 9})));
        Assert.assertEquals(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3}), service.invertTree(TreeNode.buildAnyWithArr(new Integer[]{2, 3, 1})));
        Assert.assertEquals(TreeNode.buildAnyWithArr(new Integer[]{}), service.invertTree(TreeNode.buildAnyWithArr(new Integer[]{})));

    }

    @Test
    public void invertTreeBfs() {
        Assert.assertEquals(TreeNode.buildAnyWithArr(new Integer[]{4, 7, 2, 9, 6, 3, 1}), service.invertTreeBfs(TreeNode.buildAnyWithArr(new Integer[]{4, 2, 7, 1, 3, 6, 9})));
        Assert.assertEquals(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3}), service.invertTreeBfs(TreeNode.buildAnyWithArr(new Integer[]{2, 3, 1})));
        Assert.assertEquals(TreeNode.buildAnyWithArr(new Integer[]{}), service.invertTreeBfs(TreeNode.buildAnyWithArr(new Integer[]{})));

    }
}