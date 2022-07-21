package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;
import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class VerticalOrderTraversalOfABinaryTreeTest {

    // @formatter:off
    @Test
    public void verticalTraversal() {
        VerticalOrderTraversalOfABinaryTree service = new VerticalOrderTraversalOfABinaryTree();
        List<List<Integer>> actual1 = service.verticalTraversal(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, null, null, 15, 7}));
        List<List<Integer>> expect1 = new ArrayList<>(Arrays.asList(
                Arrays.asList(9),
                Arrays.asList(3, 15),
                Arrays.asList(20),
                Arrays.asList(7)
        ));
        assertTrue(CollectionUtils.equals(actual1, expect1));

        List<List<Integer>> actual2 = service.verticalTraversal(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        List<List<Integer>> expect2 = new ArrayList<>(Arrays.asList(
                Arrays.asList(4),
                Arrays.asList(2),
                Arrays.asList(1,5,6),
                Arrays.asList(3),
                Arrays.asList(7)
        ));
        assertTrue(CollectionUtils.equals(actual2, expect2));

        List<List<Integer>> actual3 = service.verticalTraversal(TreeNode.buildAnyWithArr(new Integer[]{1,2,3,4,6,5,7}));
        assertTrue(CollectionUtils.equals(actual3, expect2));

        VerticalOrderTraversalOfABinaryTree.Sort sort = new VerticalOrderTraversalOfABinaryTree.Sort();
        actual1 = sort.verticalTraversal(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, null, null, 15, 7}));
        assertTrue(CollectionUtils.equals(actual1, expect1));

        actual2 = service.verticalTraversal(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        assertTrue(CollectionUtils.equals(actual2, expect2));

        actual3 = service.verticalTraversal(TreeNode.buildAnyWithArr(new Integer[]{1,2,3,4,6,5,7}));
        assertTrue(CollectionUtils.equals(actual3, expect2));
    }
    // @formatter:on
}