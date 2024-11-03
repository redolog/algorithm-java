package com.algorithm.dataStructure.tree.bst.majorityElement;


import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class FindModeInBinarySearchTreeTest {

    @Test
    public void findMode() {
        TreeNode root = TreeNode.buildAny(1, 0, 1, 0, 0, 1, 1, 0);
        int[] ansMapCnt = new FindModeInBinarySearchTree.MapCntSolution().findMode(root);
        int[] ansInOrderBST = new FindModeInBinarySearchTree.InOrderBSTSolution().findMode(root);
        int[] ans1 = {0, 1};
        Assert.assertArrayEquals(ans1, ansMapCnt);
        Assert.assertArrayEquals(ans1, ansInOrderBST);
    }

}