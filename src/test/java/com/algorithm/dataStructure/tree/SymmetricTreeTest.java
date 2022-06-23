package com.algorithm.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class SymmetricTreeTest {

    SymmetricTree service = new SymmetricTree();

    @Test
    public void isSymmetric() {

        Assert.assertTrue(service.isSymmetric(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        Assert.assertFalse(service.isSymmetric(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, null, 3, null, 3})));
        Assert.assertFalse(service.isSymmetric(TreeNode.buildAnyWithArr(new Integer[]{2, 3, 3, 4, 5, null, 4})));

        Assert.assertTrue(service.isSymmetricDfs(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        Assert.assertFalse(service.isSymmetricDfs(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, null, 3, null, 3})));
        Assert.assertFalse(service.isSymmetricDfs(TreeNode.buildAnyWithArr(new Integer[]{2, 3, 3, 4, 5, null, 4})));

        Assert.assertTrue(service.isSymmetricQueue(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        Assert.assertFalse(service.isSymmetricQueue(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, null, 3, null, 3})));
        Assert.assertFalse(service.isSymmetricQueue(TreeNode.buildAnyWithArr(new Integer[]{2, 3, 3, 4, 5, null, 4})));
    }
}