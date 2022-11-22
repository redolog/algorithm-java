package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrangeCoinsTest {

    @Test
    public void arrangeCoins() {
        ArrangeCoins service = new ArrangeCoins();
        assertEquals(2, service.arrangeCoins(5));
        assertEquals(3, service.arrangeCoins(8));
        assertEquals(1, service.arrangeCoins(2));
        assertEquals(1, service.arrangeCoins(1));
        assertEquals(60070, service.arrangeCoins(1804289383));
    }
}