package com.algorithm.dataStructure.tree.cousin;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CousinsInBinaryTreeIITest {

    @Test
    public void replaceValueInTree() {
        CousinsInBinaryTreeII.DFSSolultion dfs = new CousinsInBinaryTreeII.DFSSolultion();
        TreeNode a = TreeNode.buildAny(0, 0, 0, 7, 7, null, 11);
        TreeNode b = dfs.replaceValueInTree(TreeNode.buildAny(5, 4, 9, 1, 10, null, 7));
        assertTrue(a.isSameTree(b));
        assertEquals(a, b);
        assertTrue(TreeNode.buildAny(0, 0, 0).isSameTree(dfs.replaceValueInTree(TreeNode.buildAny(3, 1, 2))));
        TreeNode reqNode = TreeNode.buildAny(763, 111, 229, null, 334, 145, null, null, 338, 674, null, 513, 193, 366, null, 365, null, 600, null, null, null, null, null, 65, 926, null, null, null, 607);
        TreeNode respNode = TreeNode.buildAny(0, 0, 0, null, 145, 334, null, null, 674, 338, null, 366, 366, 706, null, 600, null, 365, null, null, null, null, null, 0, 0, null, null, null, 0);
        assertTrue(respNode.isSameTree(dfs.replaceValueInTree(reqNode)));
        CousinsInBinaryTreeII.LevelOrderSolution levelOrderSolution = new CousinsInBinaryTreeII.LevelOrderSolution();
        assertEquals(TreeNode.buildAny(0, 0, 0, 7, 7, null, 11), levelOrderSolution.replaceValueInTree(TreeNode.buildAny(5, 4, 9, 1, 10, null, 7)));
        assertTrue(TreeNode.buildAny(0, 0, 0).isSameTree(levelOrderSolution.replaceValueInTree(TreeNode.buildAny(3, 1, 2))));
        assertTrue(TreeNode.buildAny(0, 0, 0, null, 145, 334, null, null, 674, 338, null, 366, 366, 706, null, 600, null, 365, null, null, null, null, null, 0, 0, null, null, null, 0).isSameTree(levelOrderSolution.replaceValueInTree(TreeNode.buildAny(763, 111, 229, null, 334, 145, null, null, 338, 674, null, 513, 193, 366, null, 365, null, 600, null, null, null, null, null, 65, 926, null, null, null, 607))));
    }
}