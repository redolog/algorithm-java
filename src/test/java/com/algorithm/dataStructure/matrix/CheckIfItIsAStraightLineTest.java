package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfItIsAStraightLineTest {

    @Test
    public void checkStraightLine() {
        CheckIfItIsAStraightLine service = new CheckIfItIsAStraightLine();
        assertTrue(service.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        assertTrue(service.checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
        assertTrue(service.checkStraightLine(new int[][]{{0, 1}, {1, 3}, {-4, -7}, {5, 11}}));
        assertFalse(service.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        assertFalse(service.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {2, 0}}));
    }
}