package com.algorithm.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class SubStructureTest {

    SubStructure service = new SubStructure();

    @Test
    public void isSubStructure() {
        Assert.assertFalse(service.isSubStructure(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3}), TreeNode.buildAnyWithArr(new Integer[]{3, 1})));
        Assert.assertTrue(service.isSubStructure(TreeNode.buildAnyWithArr(new Integer[]{3, 4, 5, 1, 2}), TreeNode.buildAnyWithArr(new Integer[]{4, 1})));
    }
}