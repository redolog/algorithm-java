package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathsWithSumLcciTest {

    @Test
    public void pathSum() {
        PathsWithSumLcci service = new PathsWithSumLcci();
        assertEquals(3, service.pathSum(TreeNode.buildAny(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
        assertEquals(0, service.pathSum(TreeNode.buildAny(), 1));
        assertEquals(0, service.pathSum(TreeNode.buildAny(1), 0));
        assertEquals(0, service.pathSum(TreeNode.buildAny(1, 2), 4));
    }
}