package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertBinaryNumberInALinkedListToIntegerTest {

    @Test
    public void getDecimalValue() {
        ConvertBinaryNumberInALinkedListToInteger service = new ConvertBinaryNumberInALinkedListToInteger();
        assertEquals(5, service.getDecimalValue(ListNode.build(1, 0, 1)));
        assertEquals(0, service.getDecimalValue(ListNode.build(0)));
        assertEquals(1, service.getDecimalValue(ListNode.build(1)));
        assertEquals(18880, service.getDecimalValue(ListNode.build(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0)));
        assertEquals(5, service.getDecimalValue2(ListNode.build(1, 0, 1)));
        assertEquals(0, service.getDecimalValue2(ListNode.build(0)));
        assertEquals(1, service.getDecimalValue2(ListNode.build(1)));
        assertEquals(18880, service.getDecimalValue2(ListNode.build(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0)));
        assertEquals(5, service.getDecimalValue3(ListNode.build(1, 0, 1)));
        assertEquals(0, service.getDecimalValue3(ListNode.build(0)));
        assertEquals(1, service.getDecimalValue3(ListNode.build(1)));
        assertEquals(18880, service.getDecimalValue3(ListNode.build(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0)));
    }
}