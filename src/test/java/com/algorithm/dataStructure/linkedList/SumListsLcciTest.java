package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumListsLcciTest {

    @Test
    public void addTwoNumbers() {
        SumListsLcci service = new SumListsLcci();
        assertEquals(ListNode.build(2, 1, 9), service.addTwoNumbers(ListNode.build(7, 1, 6), ListNode.build(5, 9, 2)));
    }
}