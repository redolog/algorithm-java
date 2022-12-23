package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindValueOfVariableAfterPerformingOperationsTest {

    @Test
    public void finalValueAfterOperations() {
        FindValueOfVariableAfterPerformingOperations service = new FindValueOfVariableAfterPerformingOperations();
        assertEquals(1, service.finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
        assertEquals(3, service.finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));
        assertEquals(0, service.finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"}));
    }
}