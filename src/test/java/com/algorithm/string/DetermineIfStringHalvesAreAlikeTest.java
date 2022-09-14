package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DetermineIfStringHalvesAreAlikeTest {

    @Test
    public void halvesAreAlike() {
        DetermineIfStringHalvesAreAlike service = new DetermineIfStringHalvesAreAlike();
        assertTrue(service.halvesAreAlike("book"));
        assertFalse(service.halvesAreAlike("textbook"));
    }
}