package com.algorithm.dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;


public class TreeNodeTest {

    @Test
    public void buildWithArr() {
        TreeNode treeNode = TreeNode.buildCompleteWithArr(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(treeNode);
    }

    @Test
    public void buildWithVals() {
        TreeNode tree1 = TreeNode.buildAny(3, 9, 20, null, null, 15, 7);
        TreeNode tree2 = TreeNode.buildWithVals(new Integer[]{3, 9, 20, null, null, 15, 7});
        Assert.assertTrue(tree1.isSameTree(tree2));
    }
}