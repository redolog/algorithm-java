package com.algorithm.probability;

import com.algorithm.constant.Const;
import org.junit.Test;

import java.util.Arrays;

public class Rand10UsingRand7Test {

    @Test
    public void testRand10UsingRand7() {
        Rand10UsingRand7.Binary binary = new Rand10UsingRand7.Binary();

        int cnt = Const.DATA_SIZE;
        int[] randArr = new int[16];
        for (int i = 0; i < cnt; i++) {
            int randNum = binary.rand16();
            randArr[randNum]++;
        }
        System.out.println(Arrays.toString(randArr));
        int[] randArr2 = new int[11];
        for (int i = 0; i < cnt; i++) {
            int randNum = binary.rand10();
            randArr2[randNum]++;
        }
        System.out.println(Arrays.toString(randArr2));

        Rand10UsingRand7.Septenary septenary = new Rand10UsingRand7.Septenary();
        int[] randArr3 = new int[11];
        for (int i = 0; i < cnt; i++) {
            int randNum = septenary.rand10();
            randArr3[randNum]++;
        }
        System.out.println(Arrays.toString(randArr3));
    }
}