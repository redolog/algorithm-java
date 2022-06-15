package com.algorithm.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class IsValidBstTest {
    IsValidBst service = new IsValidBst();

    @Test
    public void isValidBST() {
        Assert.assertTrue(service.isValidBSTInOrder(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3})));
        Assert.assertFalse(service.isValidBSTInOrder(TreeNode.buildAnyWithArr(new Integer[]{5, 1, 4, null, null, 3, 6})));
        Assert.assertFalse(service.isValidBSTInOrder(TreeNode.buildAnyWithArr(new Integer[]{5, 4, 6, null, null, 3, 7})));
    }

    @Test
    public void isValidBSTWithRange() {

        Assert.assertTrue(service.isValidBSTWithRange(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3})));
        Assert.assertFalse(service.isValidBSTWithRange(TreeNode.buildAnyWithArr(new Integer[]{5, 1, 4, null, null, 3, 6})));
        Assert.assertFalse(service.isValidBSTWithRange(TreeNode.buildAnyWithArr(new Integer[]{5, 4, 6, null, null, 3, 7})));
    }

    @Test
    public void isValidBSTInOrderWithStack() {
        Assert.assertTrue(service.isValidBSTInOrderWithStack(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3})));
        Assert.assertFalse(service.isValidBSTInOrderWithStack(TreeNode.buildAnyWithArr(new Integer[]{5, 1, 4, null, null, 3, 6})));
        Assert.assertFalse(service.isValidBSTInOrderWithStack(TreeNode.buildAnyWithArr(new Integer[]{5, 4, 6, null, null, 3, 7})));

    }
}