package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedBinaryTreeTest {

    @Test
    public void isBalanced() {
        BalancedBinaryTree.UpToDown up2Down = new BalancedBinaryTree.UpToDown();
        assertTrue(up2Down.isBalanced(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertTrue(up2Down.isBalanced(TreeNode.buildAnyWithArr(new Integer[]{})));
        assertFalse(up2Down.isBalanced(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        assertFalse(up2Down.isBalanced(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4})));

        BalancedBinaryTree.DownToUp down2Up = new BalancedBinaryTree.DownToUp();
        assertTrue(down2Up.isBalanced(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertTrue(down2Up.isBalanced(TreeNode.buildAnyWithArr(new Integer[]{})));
        assertFalse(down2Up.isBalanced(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        assertFalse(down2Up.isBalanced(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4})));
    }
}