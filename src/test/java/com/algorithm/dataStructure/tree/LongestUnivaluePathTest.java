package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestUnivaluePathTest {

    @Test
    public void longestUnivaluePath() {
        LongestUnivaluePath service = new LongestUnivaluePath();
        assertEquals(2, service.longestUnivaluePath(TreeNode.buildAny(5, 4, 5, 1, 1, 5)));
        assertEquals(2, service.longestUnivaluePath(TreeNode.buildAny(1, 4, 5, 4, 4, 5)));
    }
}