package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeMessageTest {

    @Test
    public void decodeMessage() {
        DecodeMessage service = new DecodeMessage();
        assertEquals("this is a secret", service.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        assertEquals("the five boxing wizards jump quickly", service.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}