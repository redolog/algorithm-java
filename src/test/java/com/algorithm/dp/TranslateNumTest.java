package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateNumTest {

    @Test
    public void translateNum() {
        TranslateNum dp = new TranslateNum();
        assertEquals(5, dp.translateNum(12258));
        assertEquals(2, dp.translateNum(25));
        assertEquals(1, dp.translateNum(506));

        TranslateNum.ScrollArray scrollArray = new TranslateNum.ScrollArray();
        assertEquals(5, scrollArray.translateNum(12258));
        assertEquals(2, scrollArray.translateNum(25));
        assertEquals(1, scrollArray.translateNum(506));
    }
}