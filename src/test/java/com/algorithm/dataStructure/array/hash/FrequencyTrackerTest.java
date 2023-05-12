package com.algorithm.dataStructure.array.hash;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrequencyTrackerTest {

    @Test
    public void test() {
        FrequencyTracker.SetSolution tracker = new FrequencyTracker.SetSolution();
        assertFalse(tracker.hasFrequency(1));
        tracker.add(3);
        tracker.add(1);
        assertTrue(tracker.hasFrequency(1));
        tracker.add(3);
        assertTrue(tracker.hasFrequency(2));
        tracker.add(1);
        assertTrue(tracker.hasFrequency(2));
        tracker.deleteOne(10);
        assertTrue(tracker.hasFrequency(2));
        tracker.deleteOne(6);
        tracker.add(7);
        tracker.deleteOne(10);
        assertTrue(tracker.hasFrequency(2));
        assertTrue(tracker.hasFrequency(1));
        tracker.add(1);
        tracker.add(2);
        tracker.add(3);
        assertTrue(tracker.hasFrequency(1));
        tracker.deleteOne(3);
        assertTrue(tracker.hasFrequency(2));
        assertTrue(tracker.hasFrequency(3));
        FrequencyTracker.CntSolution cntSolution = new FrequencyTracker.CntSolution();
        assertFalse(cntSolution.hasFrequency(1));
        cntSolution.add(3);
        cntSolution.add(1);
        assertTrue(cntSolution.hasFrequency(1));
        cntSolution.add(3);
        assertTrue(cntSolution.hasFrequency(2));
        cntSolution.add(1);
        assertTrue(cntSolution.hasFrequency(2));
        cntSolution.deleteOne(10);
        assertTrue(cntSolution.hasFrequency(2));
        cntSolution.deleteOne(6);
        cntSolution.add(7);
        cntSolution.deleteOne(10);
        assertTrue(cntSolution.hasFrequency(2));
        assertTrue(cntSolution.hasFrequency(1));
        cntSolution.add(1);
        cntSolution.add(2);
        cntSolution.add(3);
        assertTrue(cntSolution.hasFrequency(1));
        cntSolution.deleteOne(3);
        assertTrue(cntSolution.hasFrequency(2));
        assertTrue(cntSolution.hasFrequency(3));
    }
}