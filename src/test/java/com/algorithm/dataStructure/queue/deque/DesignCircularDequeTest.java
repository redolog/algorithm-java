package com.algorithm.dataStructure.queue.deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class DesignCircularDequeTest {

    @Test
    public void testDesignCircularDeque() {
        DesignCircularDeque.ArrayCircularDeque deq = new DesignCircularDeque.ArrayCircularDeque(3);
        assertTrue(deq.insertLast(1));
        assertTrue(deq.insertLast(2));
        assertTrue(deq.insertFront(3));
        assertFalse(deq.insertFront(4));
        assertEquals(2, deq.getRear());
        assertTrue(deq.isFull());
        assertTrue(deq.deleteLast());
        assertTrue(deq.insertFront(4));
        assertEquals(4, deq.getFront());

        DesignCircularDeque.ArrayCircularDeque2 deq2 = new DesignCircularDeque.ArrayCircularDeque2(3);
        assertTrue(deq2.insertLast(1));
        assertTrue(deq2.insertLast(2));
        assertTrue(deq2.insertFront(3));
        assertFalse(deq2.insertFront(4));
        assertEquals(2, deq2.getRear());
        assertTrue(deq2.isFull());
        assertTrue(deq2.deleteLast());
        assertTrue(deq2.insertFront(4));
        assertEquals(4, deq2.getFront());

        DesignCircularDeque.LinkedCircularDeque deq3 = new DesignCircularDeque.LinkedCircularDeque(3);
        assertTrue(deq3.insertLast(1));
        assertTrue(deq3.insertLast(2));
        assertTrue(deq3.insertFront(3));
        assertFalse(deq3.insertFront(4));
        assertEquals(2, deq3.getRear());
        assertTrue(deq3.isFull());
        assertTrue(deq3.deleteLast());
        assertTrue(deq3.insertFront(4));
        assertEquals(4, deq3.getFront());
    }

}