package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class DeleteNodeTest {

    @Test
    public void deleteNodeTest() {
        Assert.assertEquals(ListNode.build(4,1,9),DeleteNode.deleteNodeTwoPointer(ListNode.build(4,5,1,9),5));
        Assert.assertEquals(ListNode.build(4,5,9),DeleteNode.deleteNodeTwoPointer(ListNode.build(4,5,1,9),1));
        Assert.assertEquals(ListNode.build(4,1,9),DeleteNode.deleteNodeSinglePointer(ListNode.build(4,5,1,9),5));
        Assert.assertEquals(ListNode.build(4,5,9),DeleteNode.deleteNodeSinglePointer(ListNode.build(4,5,1,9),1));
    }
}