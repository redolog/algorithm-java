package com.algorithm.dataStructure.linkedList.monotonous;

import com.algorithm.dataStructure.linkedList.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NextGreaterNodeInLinkedListTest {

    @Test
    public void nextLargerNodes() {
        NextGreaterNodeInLinkedList service = new NextGreaterNodeInLinkedList();
        assertArrayEquals(new int[]{5, 5, 0}, service.nextLargerNodes(ListNode.build(2, 1, 5)));
        assertArrayEquals(new int[]{7, 0, 5, 5, 0}, service.nextLargerNodes(ListNode.build(2, 7, 4, 3, 5)));
        assertArrayEquals(new int[]{0, 0}, service.nextLargerNodes(ListNode.build(3, 3)));
    }
}