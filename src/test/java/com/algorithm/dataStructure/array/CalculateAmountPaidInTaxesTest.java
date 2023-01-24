package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateAmountPaidInTaxesTest {

    @Test
    public void calculateTax() {
        CalculateAmountPaidInTaxes service = new CalculateAmountPaidInTaxes();
        double delta = Math.pow(10, -5);
        assertEquals(2.65000, service.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10), delta);
        assertEquals(0.25000, service.calculateTax(new int[][]{{1, 0}, {4, 25}, {5, 50}}, 2), delta);
        assertEquals(0.00000, service.calculateTax(new int[][]{{2, 50}}, 0), delta);
    }
}