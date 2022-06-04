package com.algorithm.dataStructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubTreeOfAnotherTreeTest {

    SubTreeOfAnotherTree service;

    @Before
    public void init() {
        service = new SubTreeOfAnotherTree();
    }

    @Test
    public void isSubtree() {
        TreeNode root = TreeNode.buildAnyWithArr(new Integer[]{73, 74, 72, 73, 73, 71, 73, 72, 72, 74, 72, null, 72, 74, 72, 73, 71, 71, 71, 73, null, 71, 73, 73, 73, 75, 75, 71, 73, 74, 74, 70, 70, 70, 72, 70, 72, 74, 74, 72, 72, 72, null, 72, null, null, null, null, null, 74, 76, 70, 72, null, 72, 75, 75, null, null, null, 71, null, null, 71, 71, 71, 73, 71, null, 71, 71, null, 75, null, null, 71, 73, 71, 73, null, 73, null, null, null, 75, null, 77, null, 71, null, null, null, 73, 74, null, 74, null, 72, null, 72, 70, 72, null, null, null, 72, 74, 70, null, 72, null, null, 72, null, null, 72, null, 74, 74, 70, null, null, null, 74, null, 74, null, 76, null, null, null, 72, 74, 75, 75, 73, 73, 71, 73, 73, null, 69, null, 71, 73, 71, 71, 73, null, null, null, null, null, 73, 71, 71, 73, null, null, 73, 73, 69, 69, 75, 73, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 72, null, 72, null, null, 70, 70, null, null, 74, 70, 72, 70, null, null, null, 72, null, 70, 70, null, null, 72, 74, null, null, null, null, 68, 70, null, 70, null, null, null, 74, null, null, null, null, null, null, null, null, null, null, null, null, 71, null, null, null, 73, 73, null, null, null, 71, 73, null, 75, 75, 67, null, null, 71, 71, null, null, null, null, 72, null, 72, null, null, null, null, 74, null, null, null, 76, 74, null, null, null, 72, null, null, null, null, null, null, null, null, 77, 77, null, 75, null, null, 76, 76, null, null, null, null, 75, 77, null, null, null, 74});
        TreeNode subRoot = TreeNode.buildAnyWithArr(new Integer[]{72, 71, 71, 70, 72, 70, null, null, null, 71, null, null, null, null, 72});
        System.out.println(subRoot);

        Assert.assertTrue(service.isSubtree(root, subRoot));

    }
}