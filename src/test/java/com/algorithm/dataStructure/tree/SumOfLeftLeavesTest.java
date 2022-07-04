package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfLeftLeavesTest {

    SumOfLeftLeaves service = new SumOfLeftLeaves();

    @Test
    public void sumOfLeftLeaves() {
        assertEquals(24, service.sumOfLeftLeaves(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertEquals(0, service.sumOfLeftLeaves(TreeNode.buildAnyWithArr(new Integer[]{1})));
        assertEquals(4, service.sumOfLeftLeaves(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5})));
    }
}