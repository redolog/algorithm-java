package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddOneRowToTreeTest {

    @Test
    public void addOneRow() {
        AddOneRowToTree.DFS dfs = new AddOneRowToTree.DFS();
        TreeNode ans1 = dfs.addOneRow(TreeNode.buildAnyWithArr(new Integer[]{4, 2, 6, 3, 1, 5}), 1, 2);
        System.out.println(ans1);
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{4, 1, 1, 2, null, null, 6, 3, 1, 5}), ans1);
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{4, 2, null, 1, 1, 3, null, null, 1}), dfs.addOneRow(TreeNode.buildAnyWithArr(new Integer[]{4, 2, null, 3, 1}), 1, 3));

        AddOneRowToTree.BFS bfs = new AddOneRowToTree.BFS();
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{4, 1, 1, 2, null, null, 6, 3, 1, 5}), bfs.addOneRow(TreeNode.buildAnyWithArr(new Integer[]{4, 2, 6, 3, 1, 5}), 1, 2));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{4, 2, null, 1, 1, 3, null, null, 1}), bfs.addOneRow(TreeNode.buildAnyWithArr(new Integer[]{4, 2, null, 3, 1}), 1, 3));

    }
}