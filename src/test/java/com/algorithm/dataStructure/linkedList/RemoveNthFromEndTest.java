package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class RemoveNthFromEndTest {

    @Test
    public void removeNthFromEndTest() {

//        Assert.assertEquals(ListNode.build(1,2,3,5), RemoveNthFromEnd.removeNthFromEnd(ListNode.build(1,2,3,4,5),2));
        Assert.assertEquals(ListNode.build(1, 2, 3, 5), RemoveNthFromEnd.removeNthFromEndStack2(ListNode.build(1, 2, 3, 4, 5), 2));

    }

    @Test
    public void removeNthFromEndCalcLen() {
        Assert.assertEquals(ListNode.build(1, 2, 3, 5), RemoveNthFromEnd.removeNthFromEndCalcLen(ListNode.build(1, 2, 3, 4, 5), 2));
        Assert.assertEquals(ListNode.build(1), RemoveNthFromEnd.removeNthFromEndCalcLen(ListNode.build(1, 2), 1));

    }

    @Test
    public void removeNthFromEndTwoPointer() {
        Assert.assertEquals(ListNode.build(1, 2, 3, 5), RemoveNthFromEnd.removeNthFromEndTwoPointer(ListNode.build(1, 2, 3, 4, 5), 2));
        Assert.assertEquals(ListNode.build(1, 2, 4, 5), RemoveNthFromEnd.removeNthFromEndTwoPointer(ListNode.build(1, 2, 3, 4, 5), 3));
        Assert.assertEquals(ListNode.build(1, 3, 4, 5), RemoveNthFromEnd.removeNthFromEndTwoPointer(ListNode.build(1, 2, 3, 4, 5), 4));
        Assert.assertEquals(ListNode.build(1), RemoveNthFromEnd.removeNthFromEndTwoPointer(ListNode.build(1, 2), 1));

    }
}