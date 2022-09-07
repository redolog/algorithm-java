package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RearrangeSpacesBetweenWordsTest {

    @Test
    public void reorderSpaces() {
        RearrangeSpacesBetweenWords service = new RearrangeSpacesBetweenWords();
        assertEquals("this   is   a   sentence", service.reorderSpaces("  this   is  a sentence "));
        assertEquals("practice   makes   perfect ", service.reorderSpaces(" practice   makes   perfect"));
        assertEquals("hello   world", service.reorderSpaces("hello   world"));
        assertEquals("walks  udp  package  into  bar  a ", service.reorderSpaces("  walks  udp package   into  bar a"));
        assertEquals("a", service.reorderSpaces("a"));
    }
}