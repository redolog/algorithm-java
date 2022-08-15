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
    }

}