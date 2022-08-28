package com.algorithm.dataStructure.array.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximizeTheConfusionOfAnExamTest {

    @Test
    public void maxConsecutiveAnswers() {
        MaximizeTheConfusionOfAnExam service = new MaximizeTheConfusionOfAnExam();
        assertEquals(4, service.maxConsecutiveAnswers("TTFF", 2));
        assertEquals(3, service.maxConsecutiveAnswers("TFFT", 1));
        assertEquals(5, service.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}