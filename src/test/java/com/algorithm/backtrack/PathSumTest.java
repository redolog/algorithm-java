package com.algorithm.backtrack;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathSumTest {

    @Test
    public void hasPathSum() {
        PathSum.DFS dfs = new PathSum.DFS();
        assertFalse(dfs.hasPathSum(TreeNode.buildAnyWithArr(new Integer[]{1, 2}), 1));
        assertTrue(dfs.hasPathSum(TreeNode.buildAnyWithArr(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
        assertFalse(dfs.hasPathSum(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3}), 5));
        PathSum.Recursion recursion = new PathSum.Recursion();
        assertFalse(recursion.hasPathSum(TreeNode.buildAnyWithArr(new Integer[]{1, 2}), 1));
        assertTrue(recursion.hasPathSum(TreeNode.buildAnyWithArr(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
        assertFalse(recursion.hasPathSum(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3}), 5));
    }
}