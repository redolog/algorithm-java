package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RichestCustomerWealthTest {

    @Test
    public void maximumWealth() {
        RichestCustomerWealth.ForLoopSum forLoopSum = new RichestCustomerWealth.ForLoopSum();
        assertEquals(6, forLoopSum.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        assertEquals(10, forLoopSum.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
        assertEquals(17, forLoopSum.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
        RichestCustomerWealth.SteamMapSum steamMapSum = new RichestCustomerWealth.SteamMapSum();
        assertEquals(6, steamMapSum.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        assertEquals(10, steamMapSum.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
        assertEquals(17, steamMapSum.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}