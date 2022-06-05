package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CopyListWithRandomPointerTest {

    CopyListWithRandomPointer service;

    @Before
    public void init() {
        service = new CopyListWithRandomPointer();
    }

    @Test
    public void copyRandomList() {
        Integer[][] vals = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        RandomListNode head = RandomListNode.build(vals);
        RandomListNode newHead = service.copyRandomList(head);

        Assert.assertNotNull(head);
        Assert.assertNotNull(newHead);

        RandomListNode curr = head;
        RandomListNode newCurr = newHead;
        while (curr != null) {

            Assert.assertNotEquals(curr.hashCode(), newCurr.hashCode());
            Assert.assertEquals(curr.val, newCurr.val);
            RandomListNode random = curr.random;
            RandomListNode newRandom = newCurr.random;
            if (random == null) {
                Assert.assertNull(newRandom);
            }else{
                Assert.assertNotEquals(random.hashCode(), newRandom.hashCode());
                Assert.assertEquals(random.val, newRandom.val);
            }

            curr = curr.next;
            newCurr = newCurr.next;
        }

    }

    @Test
    public void copyRandomListWithShadow() {

        Integer[][] vals = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        RandomListNode head = RandomListNode.build(vals);
        RandomListNode newHead = service.copyRandomListWithShadow(head);

        Assert.assertNotNull(head);
        Assert.assertNotNull(newHead);

        RandomListNode curr = head;
        RandomListNode newCurr = newHead;
        while (curr != null) {

            Assert.assertNotEquals(curr.hashCode(), newCurr.hashCode());
            Assert.assertEquals(curr.val, newCurr.val);
            RandomListNode random = curr.random;
            RandomListNode newRandom = newCurr.random;
            if (random == null) {
                Assert.assertNull(newRandom);
            }else{
                Assert.assertNotEquals(random.hashCode(), newRandom.hashCode());
                Assert.assertEquals(random.val, newRandom.val);
            }

            curr = curr.next;
            newCurr = newCurr.next;
        }
    }
}