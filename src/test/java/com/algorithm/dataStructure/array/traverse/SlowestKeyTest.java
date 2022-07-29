package com.algorithm.dataStructure.array.traverse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SlowestKeyTest {

    @Test
    public void slowestKey() {
        SlowestKey service = new SlowestKey();
        assertEquals('c', service.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        assertEquals('a', service.slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
        assertEquals('b', service.slowestKey(new int[]{1, 2}, "ba"));
    }
}