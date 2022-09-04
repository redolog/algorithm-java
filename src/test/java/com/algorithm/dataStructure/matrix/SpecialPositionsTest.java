package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpecialPositionsTest {

    @Test
    public void numSpecial() {
        SpecialPositions service = new SpecialPositions();
        assertEquals(1, service.numSpecial(new int[][]{{1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}}));
        assertEquals(3, service.numSpecial(new int[][]{{1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}));
        assertEquals(3, service.numSpecial(new int[][]{{0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}}));
    }
}