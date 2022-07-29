package com.algorithm.dataStructure.array.traverse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestWordDistanceTest {

    @Test
    public void shortestDistance() {
        ShortestWordDistance service = new ShortestWordDistance();
        assertEquals(3, service.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
        assertEquals(1, service.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "makes"));
    }
}