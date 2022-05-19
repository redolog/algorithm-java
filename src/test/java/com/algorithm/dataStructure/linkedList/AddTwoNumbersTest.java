package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbersTest() {
        Assert.assertEquals(ListNode.build(7, 0, 8),
                AddTwoNumbers.addTwoNumbers(ListNode.build(2, 4, 3), ListNode.build(5, 6, 4)));
        Assert.assertEquals(ListNode.build(0),
                AddTwoNumbers.addTwoNumbers(ListNode.build(0), ListNode.build(0)));
        Assert.assertEquals(ListNode.build(8,9,9,9,0,0,0,1),
                AddTwoNumbers.addTwoNumbers(ListNode.build(9,9,9,9,9,9,9), ListNode.build(9,9,9,9)));
    }
}