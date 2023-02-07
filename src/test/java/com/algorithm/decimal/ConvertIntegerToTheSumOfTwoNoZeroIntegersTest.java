package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegersTest {

    @Test
    public void getNoZeroIntegers() {
        ConvertIntegerToTheSumOfTwoNoZeroIntegers service = new ConvertIntegerToTheSumOfTwoNoZeroIntegers();
        assertArrayEquals(new int[]{1, 1}, service.getNoZeroIntegers(2));
        assertArrayEquals(new int[]{2, 9}, service.getNoZeroIntegers(11));
        assertArrayEquals(new int[]{1, 9999}, service.getNoZeroIntegers(10000));
        assertArrayEquals(new int[]{1, 68}, service.getNoZeroIntegers(69));
        assertArrayEquals(new int[]{11, 999}, service.getNoZeroIntegers(1010));
    }
}