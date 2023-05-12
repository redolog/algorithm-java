package com.algorithm.dataStructure.array.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrequencyTrackerTest {

    @Test
    public void test() {
        FrequencyTracker tracker = new FrequencyTracker();
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
    }
}