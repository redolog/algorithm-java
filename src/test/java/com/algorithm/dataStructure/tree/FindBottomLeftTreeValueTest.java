package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindBottomLeftTreeValueTest {

    @Test
    public void findBottomLeftValue() {
        FindBottomLeftTreeValue.DFS dfs = new FindBottomLeftTreeValue.DFS();

        assertEquals(1, dfs.findBottomLeftValue(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3})));
        assertEquals(7, dfs.findBottomLeftValue(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7})));
        assertEquals(1, dfs.findBottomLeftValue(TreeNode.buildAnyWithArr(new Integer[]{1})));
        assertEquals(-1, dfs.findBottomLeftValue(TreeNode.buildAnyWithArr(new Integer[]{0, null, -1})));

        FindBottomLeftTreeValue.BFS bfs = new FindBottomLeftTreeValue.BFS();

        assertEquals(1, bfs.findBottomLeftValue(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3})));
        assertEquals(7, bfs.findBottomLeftValue(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7})));
        assertEquals(1, bfs.findBottomLeftValue(TreeNode.buildAnyWithArr(new Integer[]{1})));
        assertEquals(-1, bfs.findBottomLeftValue(TreeNode.buildAnyWithArr(new Integer[]{0, null, -1})));

    }
}