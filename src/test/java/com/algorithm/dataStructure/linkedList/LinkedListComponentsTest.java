package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListComponentsTest {

    @Test
    public void numComponents() {
        LinkedListComponents service = new LinkedListComponents();
        assertEquals(2, service.numComponents(ListNode.build(0, 1, 2, 3), new int[]{0, 1, 3}));
        assertEquals(2, service.numComponents(ListNode.build(0, 1, 2, 3, 4), new int[]{0, 3, 1, 4}));
    }
}