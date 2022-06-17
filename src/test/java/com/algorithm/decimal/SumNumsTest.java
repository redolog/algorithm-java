package com.algorithm.decimal;

import org.junit.Assert;
import org.junit.Test;

public class SumNumsTest {

    SumNums service = new SumNums();

    @Test
    public void sumNums() {
        Assert.assertEquals(6, service.sumNums(3));
        Assert.assertEquals(45, service.sumNums(9));
    }
}