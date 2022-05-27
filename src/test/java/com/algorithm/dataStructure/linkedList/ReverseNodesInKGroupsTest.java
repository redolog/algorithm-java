package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ReverseNodesInKGroupsTest {

    @Test
    public void reverseKGroup() {
    }

    @Test
    public void getGroupEndByStartAndGroupSizeTest() {

        ListNode listNode = ListNode.build(1, 2, 3, 4);

        ListNode groupEnd = ReverseNodesInKGroups.getGroupEndByStartAndGroupSize(listNode, 2);
        Assert.assertEquals(2, groupEnd.val);

        groupEnd = ReverseNodesInKGroups.getGroupEndByStartAndGroupSize(listNode, 5);
        assertNull(groupEnd);
        assertNotNull(ReverseNodesInKGroups.getGroupEndByStartAndGroupSize(listNode, 4));
    }

    @Test
    public void testReverseKGroup() {
        ListNode start = ListNode.build(1, 2, 3, 4);
        ListNode end = ReverseNodesInKGroups.getGroupEndByStartAndGroupSize(start, 3);
        ListNode nextPrev = ReverseNodesInKGroups.reverseGroupNodes(start, null, ListNode.build(4));


        Assert.assertEquals(ListNode.build(3, 2, 1, 4), nextPrev);
    }

    @Test
    public void testReverseKGroup1() {
        ListNode actual = ReverseNodesInKGroups.reverseKGroup(ListNode.build(1, 2, 3, 4, 5), 2);
        Assert.assertEquals(ListNode.build(2, 1, 4, 3, 5),
                actual);
        Assert.assertEquals(ListNode.build(3,2,1,4,5),
                ReverseNodesInKGroups.reverseKGroup(ListNode.build(1, 2, 3, 4, 5), 3));
    }
}