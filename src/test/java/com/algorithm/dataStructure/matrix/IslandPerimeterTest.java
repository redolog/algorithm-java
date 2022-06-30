package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandPerimeterTest {
    IslandPerimeter service = new IslandPerimeter();

    @Test
    public void islandPerimeter() {
        assertEquals(16, service.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        assertEquals(4, service.islandPerimeter(new int[][]{{1}}));
        assertEquals(4, service.islandPerimeter(new int[][]{{1, 0}}));
    }

    @Test
    public void islandPerimeterWithDFS() {
        assertEquals(16, service.islandPerimeterWithDFS(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        assertEquals(4, service.islandPerimeterWithDFS(new int[][]{{1}}));
        assertEquals(4, service.islandPerimeterWithDFS(new int[][]{{1, 0}}));
    }
}