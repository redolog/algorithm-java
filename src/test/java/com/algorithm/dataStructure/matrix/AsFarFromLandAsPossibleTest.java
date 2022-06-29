package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AsFarFromLandAsPossibleTest {

    @Test
    public void maxDistance() {
        AsFarFromLandAsPossible service = new AsFarFromLandAsPossible();

        assertEquals(2, service.maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));
        assertEquals(4, service.maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }
}