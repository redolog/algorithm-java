package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeLinkedListTest {

    @Test
    public void isPalindrome() {
//        PalindromeLinkedList.StackSolution stackSolution = new PalindromeLinkedList.StackSolution();
//        assertTrue(stackSolution.isPalindrome(ListNode.build(1,2,2,1)));
//        assertTrue(stackSolution.isPalindrome(ListNode.build(1,0,1)));
//        assertFalse(stackSolution.isPalindrome(ListNode.build(1,2)));
        PalindromeLinkedList.TwoPointerSolution twoPointerSolution = new PalindromeLinkedList.TwoPointerSolution();
        assertTrue(twoPointerSolution.isPalindrome(ListNode.build(1, 2, 2, 1)));
        assertTrue(twoPointerSolution.isPalindrome(ListNode.build(1, 0, 1)));
        assertFalse(twoPointerSolution.isPalindrome(ListNode.build(1, 2)));
    }
}