package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateMoneyInLeetcodeBankTest {

    @Test
    public void totalMoney() {
        CalculateMoneyInLeetcodeBank service = new CalculateMoneyInLeetcodeBank();
        assertEquals(10, service.totalMoney(4));
        assertEquals(37, service.totalMoney(10));
        assertEquals(96, service.totalMoney(20));
    }
}