package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressiveWordsTest {

    @Test
    public void expressiveWords() {
        ExpressiveWords service = new ExpressiveWords();
        assertEquals(1, service.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        assertEquals(3, service.expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
        assertEquals(0, service.expressiveWords("abcd", new String[]{"abc"}));
        assertEquals(0, service.expressiveWords("heeelllooo", new String[]{"hellllo"}));
    }
}