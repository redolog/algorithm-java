package com.algorithm.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PrintWordsVerticallyTest {

    @Test
    public void printVertically() {
        PrintWordsVertically service = new PrintWordsVertically();
        assertEquals(Arrays.asList("HAY", "ORO", "WEU"), service.printVertically("HOW ARE YOU"));
        assertEquals(Arrays.asList("TBONTB", "OEROOE", "   T"), service.printVertically("TO BE OR NOT TO BE"));
        assertEquals(Arrays.asList("CIC", "OSO", "N M", "T I", "E N", "S G", "T"), service.printVertically("CONTEST IS COMING"));
    }
}