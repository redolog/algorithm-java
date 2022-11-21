package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtractTheProductAndSumOfDigitsOfAnIntegerTest {

    @Test
    public void subtractProductAndSum() {
        SubtractTheProductAndSumOfDigitsOfAnInteger service = new SubtractTheProductAndSumOfDigitsOfAnInteger();
        assertEquals(15, service.subtractProductAndSum(234));
        assertEquals(21, service.subtractProductAndSum(4421));
    }
}