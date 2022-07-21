package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthLargestTreeNodeTest {

    @Test
    public void testKthLargestTreeNode() {
        KthLargestTreeNode.ListSolution listSolution = new KthLargestTreeNode.ListSolution();
        assertEquals(4, listSolution.kthLargest(TreeNode.buildAnyWithArr(new Integer[]{3, 1, 4, null, 2}), 1));
        assertEquals(4, listSolution.kthLargest(TreeNode.buildAnyWithArr(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3));
        KthLargestTreeNode.CntSolution cntSolution = new KthLargestTreeNode.CntSolution();
        assertEquals(4, cntSolution.kthLargest(TreeNode.buildAnyWithArr(new Integer[]{3, 1, 4, null, 2}), 1));
        assertEquals(4, cntSolution.kthLargest(TreeNode.buildAnyWithArr(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3));
    }

}