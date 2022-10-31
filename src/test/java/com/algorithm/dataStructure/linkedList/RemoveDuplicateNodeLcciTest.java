package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicateNodeLcciTest {

    @Test
    public void removeDuplicateNodes() {
        RemoveDuplicateNodeLcci service = new RemoveDuplicateNodeLcci();
        assertEquals(ListNode.build(1, 2, 3), service.removeDuplicateNodes(ListNode.build(1, 2, 3, 3, 2, 1)));
        assertEquals(ListNode.build(1, 2), service.removeDuplicateNodes(ListNode.build(1, 1, 1, 1, 2)));
    }
}