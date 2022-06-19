package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class ListNodeReversePrintTest {

    ListNodeReversePrint service = new ListNodeReversePrint();

    @Test
    public void reversePrint() {
        Assert.assertArrayEquals(new int[]{2, 3, 1}, service.reversePrintWithStack(ListNode.build(1, 3, 2)));
        Assert.assertArrayEquals(new int[]{2, 3, 1}, service.reversePrint(ListNode.build(1, 3, 2)));

    }
}