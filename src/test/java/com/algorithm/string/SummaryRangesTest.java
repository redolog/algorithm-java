package com.algorithm.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SummaryRangesTest {

    @Test
    public void summaryRanges() {
        SummaryRanges service = new SummaryRanges();
        assertEquals(Arrays.asList("0->2", "4->5", "7"), service.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        assertEquals(Arrays.asList("0", "2->4", "6", "8->9"), service.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}