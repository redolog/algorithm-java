package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinishHalfQuestionsTest {

    @Test
    public void halfQuestions() {
        FinishHalfQuestions service = new FinishHalfQuestions();
        assertEquals(1, service.halfQuestions(new int[]{2, 1, 6, 2}));
        assertEquals(2, service.halfQuestions(new int[]{1, 5, 1, 3, 4, 5, 2, 5, 3, 3, 8, 6}));

    }
}