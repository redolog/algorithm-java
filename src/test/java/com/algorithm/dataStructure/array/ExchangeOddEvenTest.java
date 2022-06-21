package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

public class ExchangeOddEvenTest {

    ExchangeOddEven service = new ExchangeOddEven();

    @Test
    public void exchange() {

        Assert.assertArrayEquals(new int[]{1, 3, 2, 4}, service.exchange(new int[]{1, 2, 3, 4}));
        Assert.assertArrayEquals(new int[]{1, 3, 5}, service.exchange(new int[]{1, 3, 5}));
        Assert.assertArrayEquals(new int[]{}, service.exchange(new int[]{}));
    }
}