package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class ReverseListTest {

    @Test
    public void reverseListTest() {
        Assert.assertEquals(ListNode.build(1,2,3,4),ReverseList.reverseList(ListNode.build(4,3,2,1)));
    }
}