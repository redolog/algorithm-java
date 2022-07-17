package com.algorithm.concurrent.cow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class COWMapTest {

    @Test
    public void testCOWMap() throws InterruptedException {
        Map<Integer, Integer> srcMap = new HashMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 2);
            put(3, 3);
        }};

        COWMap<Integer, Integer> map = new COWMap<>(srcMap);
        assertEquals(Integer.valueOf(1), map.get(1));
        assertEquals(Integer.valueOf(2), map.get(2));
        assertEquals(Integer.valueOf(3), map.get(3));

        Thread t3 = new Thread(() -> {
            map.put(1, 1111);
        });
        t3.setPriority(Thread.MIN_PRIORITY);
        t3.start();
        Thread t1 = new Thread(() -> {
            map.put(1, 11);
        });
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        Thread t2 = new Thread(() -> {
            map.put(1, 111);
        });
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        TimeUnit.SECONDS.sleep(2);

        System.out.println(map.get(1));
    }
}