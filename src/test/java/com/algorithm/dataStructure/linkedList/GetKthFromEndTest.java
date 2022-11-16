package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetKthFromEndTest {

    @Test
    public void getKthFromEnd() {
        GetKthFromEnd service = new GetKthFromEnd();
        assertEquals(ListNode.build(4, 5), service.getKthFromEnd(ListNode.build(1, 2, 3, 4, 5), 2));
    }
}