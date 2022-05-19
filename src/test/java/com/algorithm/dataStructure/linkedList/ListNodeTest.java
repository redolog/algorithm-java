package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class ListNodeTest {

    @Test
    public void buildChainTest() {
        ListNode listNode = ListNode.build(1, 2, 3, 4);
        System.out.println(listNode);
        int current = 1;
        int next = 2;
        while (listNode.next != null) {
            Assert.assertEquals(current++, listNode.val);
            Assert.assertEquals(next++, listNode.next.val);

            listNode = listNode.next;
        }
    }
}