package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintBinaryTreeTest {

    @Test
    public void testPrintBinaryTree() {
        PrintBinaryTree service = new PrintBinaryTree();

        assertEquals(2, service.h(TreeNode.buildAny(1, 2)));
        assertEquals(3, service.h(TreeNode.buildAny(1, 2, 3, null, 4)));
        System.out.println(service.printTree(TreeNode.buildAny(1, 2)));
        System.out.println(service.printTree(TreeNode.buildAny(1, 2, 3, null, 4)));
    }
}