package com.algorithm.math;


import org.junit.Assert;
import org.junit.Test;

public class SumOfSquareNumbersTest {

    @Test
    public void testJudgeSquareSum() {
        SumOfSquareNumbers service = new SumOfSquareNumbers();
        Assert.assertTrue(service.judgeSquareSum(2147483600));
    }
}