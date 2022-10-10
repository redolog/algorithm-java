package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwapNodesInPairsTest {

    @Test
    public void swapPairs() {
        SwapNodesInPairs.Traversal traversal = new SwapNodesInPairs.Traversal();
        assertEquals(ListNode.build(2, 1, 4, 3), traversal.swapPairs(ListNode.build(1, 2, 3, 4)));
        assertEquals(ListNode.build(), traversal.swapPairs(ListNode.build()));
        assertEquals(ListNode.build(1), traversal.swapPairs(ListNode.build(1)));
        SwapNodesInPairs.Recursion recursion = new SwapNodesInPairs.Recursion();
        assertEquals(ListNode.build(2, 1, 4, 3), recursion.swapPairs(ListNode.build(1, 2, 3, 4)));
        assertEquals(ListNode.build(), recursion.swapPairs(ListNode.build()));
        assertEquals(ListNode.build(1), recursion.swapPairs(ListNode.build(1)));
    }
}