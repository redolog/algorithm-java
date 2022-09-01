package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FinalPricesWithASpecialDiscountInAShopTest {

    @Test
    public void testFinalPricesWithASpecialDiscountInAShop() {
        FinalPricesWithASpecialDiscountInAShop.BF bf = new FinalPricesWithASpecialDiscountInAShop.BF();
        assertArrayEquals(new int[]{4, 2, 4, 2, 3}, bf.finalPrices(new int[]{8, 4, 6, 2, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bf.finalPrices(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{9, 0, 1, 6}, bf.finalPrices(new int[]{10, 1, 1, 6}));
        FinalPricesWithASpecialDiscountInAShop.MonotonicDecreasingStack monotonicDecreasingStack = new FinalPricesWithASpecialDiscountInAShop.MonotonicDecreasingStack();
        assertArrayEquals(new int[]{4, 2, 4, 2, 3}, monotonicDecreasingStack.finalPrices(new int[]{8, 4, 6, 2, 3}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, monotonicDecreasingStack.finalPrices(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{9, 0, 1, 6}, monotonicDecreasingStack.finalPrices(new int[]{10, 1, 1, 6}));
    }

}