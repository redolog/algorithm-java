package com.algorithm.dataStructure.queue.simulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeNeededToBuyTicketsTest {

    @Test
    public void timeRequiredToBuy() {
        TimeNeededToBuyTickets service = new TimeNeededToBuyTickets();
        assertEquals(6, service.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        assertEquals(8, service.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        TimeNeededToBuyTickets.MathSolution mathSolution = new TimeNeededToBuyTickets.MathSolution();
        assertEquals(6, mathSolution.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        assertEquals(8, mathSolution.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
    }
}