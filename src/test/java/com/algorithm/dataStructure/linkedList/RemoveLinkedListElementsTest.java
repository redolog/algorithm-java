package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveLinkedListElementsTest {

    @Test
    public void removeElements() {
        RemoveLinkedListElements service = new RemoveLinkedListElements();
        assertEquals(ListNode.build(1, 2, 3, 4, 5), service.removeElements(ListNode.build(1, 2, 6, 3, 4, 5, 6), 6));
        assertEquals(ListNode.build(), service.removeElements(ListNode.build(), 1));
        assertEquals(ListNode.build(), service.removeElements(ListNode.build(7, 7, 7, 7), 7));
        assertEquals(ListNode.build(), service.removeElements(ListNode.build(1, 1, 1), 1));
        assertEquals(ListNode.build(1, 1), service.removeElements(ListNode.build(1, 2, 2, 1), 2));
    }
}