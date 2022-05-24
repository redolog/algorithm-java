package com.algorithm.probability;

import org.junit.Test;

import java.util.Arrays;

public class Rand2RandTest {

    @Test
    public void rand17() {
        int cnt = 1000000;
        int[] randArr = new int[7];
        for (int i = 0; i < cnt; i++) {
            int randNum = Rand2Rand.rand17();
            randArr[randNum - 1]++;
        }

        System.out.println(Arrays.toString(randArr));

    }
}