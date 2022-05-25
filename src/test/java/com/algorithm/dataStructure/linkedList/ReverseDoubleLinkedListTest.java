package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class ReverseDoubleLinkedListTest {

    @Test
    public void reverseDoubleLinkedList() {
        DoubleListNode reversed = DoubleListNode.build(4, 3, 2, 1);
        System.out.println("反转："+ reversed);
        DoubleListNode forward = DoubleListNode.build(1, 2, 3, 4);
        System.out.println("正向："+forward);
        Assert.assertEquals(reversed, ReverseDoubleLinkedList.reverseDoubleLinkedList(forward));
    }
}