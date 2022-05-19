package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedLinkedListTest {

    @Test
    public void mergeTwoListsTest() {
        Assert.assertEquals(
                ListNode.build(1,1,2,3,4,4),
                MergeTwoSortedLinkedList.mergeTwoLists(ListNode.build(1,2,4),ListNode.build(1,3,4))
        );
    }
}