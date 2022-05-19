package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class MiddleNodeTest {

    @Test
    public void middleNodeTest() {

        Assert.assertEquals(ListNode.build(3, 4, 5), MiddleNode.middleNode(ListNode.build(1, 2, 3, 4, 5)));
    }

    @Test
    public void middleNodeTwoPointer() {
        Assert.assertEquals(ListNode.build(3, 4, 5), MiddleNode.middleNodeTwoPointer(ListNode.build(1, 2, 3, 4, 5)));
        Assert.assertEquals(ListNode.build(3, 4), MiddleNode.middleNodeTwoPointer(ListNode.build(1, 2, 3, 4)));
    }
}