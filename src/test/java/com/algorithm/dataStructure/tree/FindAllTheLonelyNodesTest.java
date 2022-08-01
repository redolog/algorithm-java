package com.algorithm.dataStructure.tree;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class FindAllTheLonelyNodesTest {

    @Test
    public void getLonelyNodes() {
        FindAllTheLonelyNodes dfs = new FindAllTheLonelyNodes();

        assertTrue(CollectionUtils.equals(Arrays.asList(77, 55, 33, 66, 44, 22), dfs.getLonelyNodes(TreeNode.buildAnyWithArr(new Integer[]{11, 99, 88, 77, null, null, 66, 55, null, null, 44, 33, null, null, 22}))));
        assertTrue(CollectionUtils.equals(Collections.singleton(4), dfs.getLonelyNodes(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, null, 4}))));
        assertTrue(CollectionUtils.equals(Arrays.asList(6, 2), dfs.getLonelyNodes(TreeNode.buildAnyWithArr(new Integer[]{7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2}))));
        assertTrue(CollectionUtils.equals(Arrays.asList(78, 28), dfs.getLonelyNodes(TreeNode.buildAnyWithArr(new Integer[]{31, null, 78, null, 28}))));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), dfs.getLonelyNodes(TreeNode.buildAnyWithArr(new Integer[]{197}))));
    }
}