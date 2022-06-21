package com.algorithm.decimal;

import org.junit.Assert;
import org.junit.Test;

public class PrintNBitMaxNumbersTest {

    PrintNBitMaxNumbers service = new PrintNBitMaxNumbers();

    @Test
    public void maxNum() {

        Assert.assertEquals(9, service.maxNum(1));
        Assert.assertEquals(99, service.maxNum(2));
        Assert.assertEquals(999, service.maxNum(3));
    }
}