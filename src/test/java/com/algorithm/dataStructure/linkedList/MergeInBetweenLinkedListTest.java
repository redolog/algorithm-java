package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeInBetweenLinkedListTest {

    @Test
    public void mergeInBetween() {
        MergeInBetweenLinkedList service = new MergeInBetweenLinkedList();
        assertEquals(ListNode.build(0, 1, 2, 1000000, 1000001, 1000002, 5), service.mergeInBetween(ListNode.build(0, 1, 2, 3, 4, 5), 3, 4, ListNode.build(1000000, 1000001, 1000002)));
        assertEquals(ListNode.build(0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6), service.mergeInBetween(ListNode.build(0, 1, 2, 3, 4, 5, 6), 2, 5, ListNode.build(1000000, 1000001, 1000002, 1000003, 1000004)));
        assertEquals(ListNode.build(0, 3, 2, 1000000, 1000001, 1000002, 5), service.mergeInBetween(ListNode.build(0, 3, 2, 1, 4, 5), 3, 4, ListNode.build(1000000, 1000001, 1000002)));
    }
}