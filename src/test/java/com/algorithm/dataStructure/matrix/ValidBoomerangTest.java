package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidBoomerangTest {

    @Test
    public void isBoomerang() {
        ValidBoomerang service = new ValidBoomerang();
        assertTrue(service.isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        assertFalse(service.isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}