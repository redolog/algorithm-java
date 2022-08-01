package com.algorithm.dataStructure.tree;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BinaryTreePathsTest {

    @Test
    public void binaryTreePaths() {
        BinaryTreePaths.DFS dfs = new BinaryTreePaths.DFS();
        List<String> ans1 = dfs.binaryTreePaths(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, null, 5}));
        assertTrue(CollectionUtils.equals(Arrays.asList("1->2->5", "1->3"), ans1));
        assertTrue(CollectionUtils.equals(Collections.singletonList("1"), dfs.binaryTreePaths(TreeNode.buildAnyWithArr(new Integer[]{1}))));
        assertTrue(CollectionUtils.equals(Arrays.asList("1->2->5", "1->2->6", "1->3"), dfs.binaryTreePaths(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 5, 6}))));
        BinaryTreePaths.BFS bfs = new BinaryTreePaths.BFS();
        assertTrue(CollectionUtils.equals(Arrays.asList("1->2->5", "1->3"), bfs.binaryTreePaths(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, null, 5}))));
        assertTrue(CollectionUtils.equals(Collections.singletonList("1"), bfs.binaryTreePaths(TreeNode.buildAnyWithArr(new Integer[]{1}))));
        assertTrue(CollectionUtils.equals(Arrays.asList("1->2->5", "1->2->6", "1->3"), bfs.binaryTreePaths(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 5, 6}))));
    }
}