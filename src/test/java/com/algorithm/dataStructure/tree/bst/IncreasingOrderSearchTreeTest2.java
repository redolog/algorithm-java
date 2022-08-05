package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncreasingOrderSearchTreeTest2 {

    // @formatter:off
    @Test
    public void increasingBST() {
        IncreasingOrderSearchTree2.ListSolution listSolution = new IncreasingOrderSearchTree2.ListSolution();
        Assert.assertEquals(
                TreeNode.buildAnyWithArr(new Integer[]{1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9}),
                listSolution.increasingBST(TreeNode.buildAnyWithArr(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9}))
        );
        assertEquals(
                TreeNode.buildAnyWithArr(new Integer[]{1,null,5,null,7}),
                listSolution.increasingBST(TreeNode.buildAnyWithArr(new Integer[]{5,1,7}))
        );
        IncreasingOrderSearchTree2.Recursion recursion = new IncreasingOrderSearchTree2.Recursion();
        assertEquals(
                TreeNode.buildAnyWithArr(new Integer[]{1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9}),
                recursion.increasingBST(TreeNode.buildAnyWithArr(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9}))
        );
        assertEquals(
                TreeNode.buildAnyWithArr(new Integer[]{1,null,5,null,7}),
                recursion.increasingBST(TreeNode.buildAnyWithArr(new Integer[]{5,1,7}))
        );
    }
    // @formatter:on
}