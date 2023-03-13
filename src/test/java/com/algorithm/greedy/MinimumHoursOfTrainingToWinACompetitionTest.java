package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumHoursOfTrainingToWinACompetitionTest {

    @Test
    public void minNumberOfHours() {
        MinimumHoursOfTrainingToWinACompetition service = new MinimumHoursOfTrainingToWinACompetition();
        assertEquals(8, service.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
        assertEquals(0, service.minNumberOfHours(2, 4, new int[]{1}, new int[]{3}));
    }
}