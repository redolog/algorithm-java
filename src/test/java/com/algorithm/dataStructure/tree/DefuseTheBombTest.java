package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DefuseTheBombTest {

    @Test
    public void decrypt() {
        DefuseTheBomb.BF bf = new DefuseTheBomb.BF();
        assertArrayEquals(new int[]{12, 10, 16, 13}, bf.decrypt(new int[]{5, 7, 1, 4}, 3));
        assertArrayEquals(new int[]{0, 0, 0, 0}, bf.decrypt(new int[]{1, 2, 3, 4}, 0));
        assertArrayEquals(new int[]{12, 5, 6, 13}, bf.decrypt(new int[]{2, 4, 9, 3}, -2));
        DefuseTheBomb.PreSum preSum = new DefuseTheBomb.PreSum();
        assertArrayEquals(new int[]{12, 10, 16, 13}, preSum.decrypt(new int[]{5, 7, 1, 4}, 3));
        assertArrayEquals(new int[]{0, 0, 0, 0}, preSum.decrypt(new int[]{1, 2, 3, 4}, 0));
        assertArrayEquals(new int[]{12, 5, 6, 13}, preSum.decrypt(new int[]{2, 4, 9, 3}, -2));
    }
}