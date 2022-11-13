package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomSortStringTest {

    @Test
    public void customSortString() {
        CustomSortString.SortSolution sortSolution = new CustomSortString.SortSolution();
        assertEquals("cdba", sortSolution.customSortString("cba", "abcd"));
        assertEquals("cdba", sortSolution.customSortString("cbafg", "abcd"));
        assertEquals("weexv", sortSolution.customSortString("exv", "xwvee"));
        CustomSortString.CntSortSolution cntSortSolution = new CustomSortString.CntSortSolution();
        assertEquals("cbad", cntSortSolution.customSortString("cba", "abcd"));
        assertEquals("cbad", cntSortSolution.customSortString("cbafg", "abcd"));
        assertEquals("eexvw", cntSortSolution.customSortString("exv", "xwvee"));
    }
}