package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumCostOfBuyingCandiesWithDiscountTest {

    @Test
    public void minimumCost() {
        MinimumCostOfBuyingCandiesWithDiscount service = new MinimumCostOfBuyingCandiesWithDiscount();
        assertEquals(23, service.minimumCost(new int[]{6, 5, 7, 9, 2, 2}));
        assertEquals(5, service.minimumCost(new int[]{1, 2, 3}));
        assertEquals(10, service.minimumCost(new int[]{5, 5}));
    }
}