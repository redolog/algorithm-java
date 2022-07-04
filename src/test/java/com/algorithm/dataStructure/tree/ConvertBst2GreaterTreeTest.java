package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertBst2GreaterTreeTest {

    @Test
    public void convertBST() {
        ConvertBst2GreaterTree service = new ConvertBst2GreaterTree();
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8}), service.convertBST(TreeNode.buildAnyWithArr(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8})));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, null, 1}), service.convertBST(TreeNode.buildAnyWithArr(new Integer[]{0, null, 1})));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{3, 3, 2}), service.convertBST(TreeNode.buildAnyWithArr(new Integer[]{1, 0, 2})));
    }
}