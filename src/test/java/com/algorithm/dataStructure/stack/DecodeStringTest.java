package com.algorithm.dataStructure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeStringTest {

    @Test
    public void decodeString() {
        DecodeString service = new DecodeString();
        assertEquals("aaabcbc", service.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", service.decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", service.decodeString("2[abc]3[cd]ef"));
        assertEquals("abccdcdcdxyz", service.decodeString("abc3[cd]xyz"));
        assertEquals("sdfeegfeegi", service.decodeString("sd2[f2[e]g]i"));
    }
}