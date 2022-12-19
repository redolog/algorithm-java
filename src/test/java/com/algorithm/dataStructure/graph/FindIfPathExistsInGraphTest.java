package com.algorithm.dataStructure.graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindIfPathExistsInGraphTest {

    @Test
    public void validPath() {
        FindIfPathExistsInGraph service = new FindIfPathExistsInGraph();
        assertTrue(service.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        assertTrue(service.validPath(1, new int[][]{}, 0, 0));
        assertFalse(service.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }
}