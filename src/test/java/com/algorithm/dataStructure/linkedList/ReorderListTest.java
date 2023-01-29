package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReorderListTest {

    @Test
    public void reorderList() {
        ReorderList.StackSolution stackSolution = new ReorderList.StackSolution();
        assertEquals(ListNode.build(1, 4, 2, 3), stackSolution.reorderList(ListNode.build(1, 2, 3, 4)));
        assertEquals(ListNode.build(1, 5, 2, 4, 3), stackSolution.reorderList(ListNode.build(1, 2, 3, 4, 5)));
        ReorderList.ArraySolution arraySolution = new ReorderList.ArraySolution();
        assertEquals(ListNode.build(1, 4, 2, 3), arraySolution.reorderList(ListNode.build(1, 2, 3, 4)));
        assertEquals(ListNode.build(1, 5, 2, 4, 3), arraySolution.reorderList(ListNode.build(1, 2, 3, 4, 5)));
        ReorderList.MiddleReverseMergeSolution middleReverseMergeSolution = new ReorderList.MiddleReverseMergeSolution();
        assertEquals(ListNode.build(1, 4, 2, 3), middleReverseMergeSolution.reorderList(ListNode.build(1, 2, 3, 4)));
        assertEquals(ListNode.build(1, 5, 2, 4, 3), middleReverseMergeSolution.reorderList(ListNode.build(1, 2, 3, 4, 5)));
    }
}