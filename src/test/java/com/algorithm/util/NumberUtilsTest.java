package com.algorithm.util;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilsTest {

    @Test
    public void randomIndexWithRange() {

        for (int i = 0; i < 10000; i++) {
            int random = NumberUtils.randomIndexWithRange(6, 10);
            System.out.println(random);
            Assert.assertTrue(random >= 6 && random <= 10);
        }

    }
}