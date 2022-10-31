package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbersIITest {

    @Test
    public void addTwoNumbers() {
        AddTwoNumbersII service = new AddTwoNumbersII();
        assertEquals(ListNode.build(7, 8, 0, 7), service.addTwoNumbers(ListNode.build(7, 2, 4, 3), ListNode.build(5, 6, 4)));
        assertEquals(ListNode.build(8, 0, 7), service.addTwoNumbers(ListNode.build(2, 4, 3), ListNode.build(5, 6, 4)));
        assertEquals(ListNode.build(0), service.addTwoNumbers(ListNode.build(0), ListNode.build(0)));
        assertEquals(ListNode.build(10), service.addTwoNumbers(ListNode.build(5), ListNode.build(5)));
        assertEquals(ListNode.build(10), service.addTwoNumbers(ListNode.build(5), ListNode.build(5)));
    }
}