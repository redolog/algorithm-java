package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomSortStringTest {

    @Test
    public void customSortString() {
        CustomSortString service = new CustomSortString();
        assertEquals("cdba", service.customSortString("cba", "abcd"));
        assertEquals("cdba", service.customSortString("cbafg", "abcd"));
        assertEquals("weexv", service.customSortString("exv", "xwvee"));
    }
}