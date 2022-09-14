package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthNodeFromEndOfListLcciTest {

    @Test
    public void kthToLast() {
        KthNodeFromEndOfListLcci service = new KthNodeFromEndOfListLcci();
        assertEquals(4, service.kthToLast(ListNode.build(1, 2, 3, 4, 5), 2));
    }
}