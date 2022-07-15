package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateNumTest {

    @Test
    public void translateNum() {
        TranslateNum dp = new TranslateNum();
        assertEquals(5, dp.translateNum(12258));
        assertEquals(1, dp.translateNum(506));
    }
}