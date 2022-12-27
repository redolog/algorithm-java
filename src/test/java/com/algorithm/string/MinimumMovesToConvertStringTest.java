package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumMovesToConvertStringTest {

    @Test
    public void minimumMoves() {
        MinimumMovesToConvertString service = new MinimumMovesToConvertString();
        assertEquals(1, service.minimumMoves("XXX"));
        assertEquals(2, service.minimumMoves("XXOX"));
        assertEquals(0, service.minimumMoves("OOOO"));
    }
}