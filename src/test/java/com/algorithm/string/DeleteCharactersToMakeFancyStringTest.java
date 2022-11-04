package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteCharactersToMakeFancyStringTest {

    @Test
    public void makeFancyString() {
        DeleteCharactersToMakeFancyString service = new DeleteCharactersToMakeFancyString();
        assertEquals("leetcode", service.makeFancyString("leeetcode"));
        assertEquals("aabaa", service.makeFancyString("aaabaaaa"));
        assertEquals("aab", service.makeFancyString("aab"));
        assertEquals("a", service.makeFancyString("a"));
    }
}