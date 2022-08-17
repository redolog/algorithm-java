package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeepestLeavesSumTest {

    @Test
    public void testDeepestLeavesSum() {
        DeepestLeavesSum.DFS dfs = new DeepestLeavesSum.DFS();
        assertEquals(15, dfs.deepestLeavesSum(TreeNode.buildAny(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8)));
        assertEquals(19, dfs.deepestLeavesSum(TreeNode.buildAny(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)));
        DeepestLeavesSum.BFS bfs = new DeepestLeavesSum.BFS();
        assertEquals(15, bfs.deepestLeavesSum(TreeNode.buildAny(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8)));
        assertEquals(19, bfs.deepestLeavesSum(TreeNode.buildAny(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)));
    }

}