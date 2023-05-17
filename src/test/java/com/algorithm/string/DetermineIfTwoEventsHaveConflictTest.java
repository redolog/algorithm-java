package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class DetermineIfTwoEventsHaveConflictTest {

    @Test
    public void haveConflict() {
        DetermineIfTwoEventsHaveConflict.TransToMinSolution transToMinSolution = new DetermineIfTwoEventsHaveConflict.TransToMinSolution();
        assertTrue(transToMinSolution.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
        assertTrue(transToMinSolution.haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"}));
        assertFalse(transToMinSolution.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
        DetermineIfTwoEventsHaveConflict.StringCmpSolution stringCmpSolution = new DetermineIfTwoEventsHaveConflict.StringCmpSolution();
        assertTrue(stringCmpSolution.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
        assertTrue(stringCmpSolution.haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"}));
        assertFalse(stringCmpSolution.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
    }
}