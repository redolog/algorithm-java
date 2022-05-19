package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleTest {

    @Test
    public void hasCycleTest() {
        Assert.assertTrue(LinkedListCycle.hasCycle(ListNode.buildWithCycle(1,3,2,0,-4)));
        Assert.assertTrue(LinkedListCycle.hasCycle(ListNode.buildWithCycle(0,1,2)));
        Assert.assertFalse(LinkedListCycle.hasCycle(ListNode.buildWithCycle(-1,1)));
    }
}