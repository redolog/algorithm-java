package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FindLargestValueInEachTreeRowTest {

    @Test
    public void largestValues() {
        FindLargestValueInEachTreeRow service = new FindLargestValueInEachTreeRow();
        assertEquals(Arrays.asList(1, 3, 9), service.largestValues(TreeNode.buildAnyWithArr(new Integer[]{1, 3, 2, 5, 3, null, 9})));
        assertEquals(Arrays.asList(1, 3), service.largestValues(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3})));
    }

    @Test
    public void largestValuesWithDFS() {
        FindLargestValueInEachTreeRow service = new FindLargestValueInEachTreeRow();
        assertEquals(Arrays.asList(1, 3, 9), service.largestValuesWithDFS(TreeNode.buildAnyWithArr(new Integer[]{1, 3, 2, 5, 3, null, 9})));
        assertEquals(Arrays.asList(1, 3), service.largestValuesWithDFS(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3})));

    }
}