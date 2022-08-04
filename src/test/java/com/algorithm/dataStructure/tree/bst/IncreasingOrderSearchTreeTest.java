package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncreasingOrderSearchTreeTest {

    @Test
    public void increasingBST() {
        IncreasingOrderSearchTree service = new IncreasingOrderSearchTree();
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9}), service.increasingBST(TreeNode.buildAnyWithArr(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9})));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, null, 5, null, 7}), service.increasingBST(TreeNode.buildAnyWithArr(new Integer[]{5, 1, 7})));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{106, null, 783}), service.increasingBST(TreeNode.buildAnyWithArr(new Integer[]{106, null, 783})));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, null, 2, null, 3, null, 4}), service.increasingBST(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 4, null, null, 3})));
    }
}