package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class CheckCompletenessOfABstTest {

    CheckCompletenessOfABst service = new CheckCompletenessOfABst();

    @Test
    public void isCompleteTree() {
        Assert.assertTrue(service.isCompleteTree(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6})));
        Assert.assertFalse(service.isCompleteTree(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, null, 7})));
        Assert.assertFalse(service.isCompleteTree(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 15})));
    }

    @Test
    public void isCompleteTreeWithDfs() {
        Assert.assertTrue(service.isCompleteTreeWithDfs(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6})));
        Assert.assertFalse(service.isCompleteTreeWithDfs(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, null, 7})));
        Assert.assertFalse(service.isCompleteTreeWithDfs(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 15})));

    }
}