package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RottingOrangesTest {

    RottingOranges service = new RottingOranges();

    @Test
    public void orangesRotting() {
        assertEquals(4, service.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        assertEquals(-1, service.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        assertEquals(0, service.orangesRotting(new int[][]{{0, 2}}));
        assertEquals(0, service.orangesRotting(new int[][]{{0}}));

    }

    @Test
    public void orangesRottingWithSet() {
        assertEquals(4, service.orangesRottingWithSet(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        assertEquals(-1, service.orangesRottingWithSet(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        assertEquals(0, service.orangesRottingWithSet(new int[][]{{0, 2}}));
        assertEquals(0, service.orangesRottingWithSet(new int[][]{{0}}));
    }
}