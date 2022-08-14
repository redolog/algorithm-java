package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindElementsInAContaminatedBinaryTreeTest {

    @Test
    public void testFindElementsInAContaminatedBinaryTree() {
        FindElementsInAContaminatedBinaryTree.FindElements tree = new FindElementsInAContaminatedBinaryTree.FindElements(TreeNode.buildAnyWithArr(new Integer[]{-1, -1, -1, -1, -1}));
        assertTrue(tree.find(1));
        assertTrue(tree.find(3));
        assertFalse(tree.find(5));
        FindElementsInAContaminatedBinaryTree.FindElements tree2 = new FindElementsInAContaminatedBinaryTree.FindElements(TreeNode.buildAnyWithArr(new Integer[]{-1, null, -1, -1, null, -1}));
        assertTrue(tree2.find(2));
        assertFalse(tree2.find(3));
        assertFalse(tree2.find(4));
        assertTrue(tree2.find(5));

        FindElementsInAContaminatedBinaryTree.FindElements2 tree21 = new FindElementsInAContaminatedBinaryTree.FindElements2(TreeNode.buildAnyWithArr(new Integer[]{-1, -1, -1, -1, -1}));
        assertTrue(tree21.find(1));
        assertTrue(tree21.find(3));
        assertFalse(tree21.find(5));
        FindElementsInAContaminatedBinaryTree.FindElements2 tree22 = new FindElementsInAContaminatedBinaryTree.FindElements2(TreeNode.buildAnyWithArr(new Integer[]{-1, null, -1, -1, null, -1}));
        assertTrue(tree22.find(2));
        assertFalse(tree22.find(3));
        assertFalse(tree22.find(4));
        assertTrue(tree22.find(5));
    }

}