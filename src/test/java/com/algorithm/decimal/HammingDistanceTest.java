package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HammingDistanceTest {

    @Test
    public void hammingDistance() {
        HammingDistance service = new HammingDistance();
        assertEquals(2, service.hammingDistance(1, 4));
        assertEquals(1, service.hammingDistance(3, 1));
        assertEquals(2, service.hammingDistance(93, 73));
    }
}