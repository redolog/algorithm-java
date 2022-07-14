package com.algorithm.dataStructure.bit.bitmap;

import com.algorithm.util.NumberUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanArrayBitMapTest {

    @Test
    public void testBooleanArrayBitMap() {
        int n = 10000 * 10000 * 10;
        BooleanArrayBitMap booleanArrayBitMap = new BooleanArrayBitMap(n);

        int setCnt = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; ) {
            ++setCnt;
            booleanArrayBitMap.set(i);

            assertTrue(booleanArrayBitMap.get(i));

            int oldI = i;
            i += NumberUtils.randomInt(5);

            if (i - oldI > 1 && oldI + 1 < n) {
                assertFalse(booleanArrayBitMap.get(oldI + 1));
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("执行 " + setCnt + "次set操作，共耗时：" + (end - start) + " ms");

        booleanArrayBitMap.printMemoryInMB();
    }
}