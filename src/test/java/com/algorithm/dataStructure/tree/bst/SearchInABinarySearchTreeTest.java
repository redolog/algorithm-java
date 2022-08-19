package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInABinarySearchTreeTest {

    @Test
    public void testSearchInABinarySearchTree() {
        SearchInABinarySearchTree.Recursion recursion = new SearchInABinarySearchTree.Recursion();
        assertEquals(TreeNode.buildAny(2, 1, 3), recursion.searchBST(TreeNode.buildAny(4, 2, 7, 1, 3), 2));
        assertEquals(TreeNode.buildAny(), recursion.searchBST(TreeNode.buildAny(4, 2, 7, 1, 3), 5));
        SearchInABinarySearchTree.Traverse traverse = new SearchInABinarySearchTree.Traverse();
        assertEquals(TreeNode.buildAny(2, 1, 3), traverse.searchBST(TreeNode.buildAny(4, 2, 7, 1, 3), 2));
        assertEquals(TreeNode.buildAny(), traverse.searchBST(TreeNode.buildAny(4, 2, 7, 1, 3), 5));
    }

}