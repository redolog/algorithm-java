package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsecutiveCharactersTest {

    @Test
    public void maxPower() {
        ConsecutiveCharacters service = new ConsecutiveCharacters();
        assertEquals(2, service.maxPower("leetcode"));
        assertEquals(5, service.maxPower("abbcccddddeeeeedcba"));
    }
}