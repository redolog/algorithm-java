package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTimeToBuyAndSaleStockTest {

    @Test
    public void maxProfit() {
        BestTimeToBuyAndSaleStock service = new BestTimeToBuyAndSaleStock();
        assertEquals(5, service.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, service.maxProfit(new int[]{7, 6, 4, 3, 1}));
        BestTimeToBuyAndSaleStock.ScrollArray scrollArray = new BestTimeToBuyAndSaleStock.ScrollArray();
        assertEquals(5, scrollArray.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, scrollArray.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}