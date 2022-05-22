package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleTest {

    @Test
    public void hasCycleTest() {
        Assert.assertTrue(LinkedListCycle.hasCycle(ListNode.buildWithCycle(1, 3, 2, 0, -4)));
        Assert.assertTrue(LinkedListCycle.hasCycle(ListNode.buildWithCycle(0, 1, 2)));
        Assert.assertFalse(LinkedListCycle.hasCycle(ListNode.buildWithCycle(-1, 1)));
    }

    @Test
    public void detectCycle() {
        Assert.assertEquals(2, LinkedListCycle.detectCycle(ListNode.buildWithCycle(1, 3, 2, 0, -4)).val);
        Assert.assertEquals(1, LinkedListCycle.detectCycle(ListNode.buildWithCycle(0, 1, 2)).val);
        // no cycle
        Assert.assertNull(LinkedListCycle.detectCycle(ListNode.build(1)));
    }

    @Test
    public void detectCycleWithMath() {
        Assert.assertEquals(2, LinkedListCycle.detectCycleWithMath(ListNode.buildWithCycle(1, 3, 2, 0, -4)).val);
        Assert.assertEquals(1, LinkedListCycle.detectCycleWithMath(ListNode.buildWithCycle(0, 1, 2)).val);
        // no cycle
        Assert.assertNull(LinkedListCycle.detectCycleWithMath(ListNode.build(1)));
    }
}