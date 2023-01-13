package com.algorithm.string.subSequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RearrangeCharactersToMakeTargetStringTest {

    @Test
    public void rearrangeCharacters() {
        RearrangeCharactersToMakeTargetString service = new RearrangeCharactersToMakeTargetString();
        assertEquals(2, service.rearrangeCharacters("ilovecodingonleetcode", "code"));
        assertEquals(1, service.rearrangeCharacters("abcba", "abc"));
        assertEquals(1, service.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
    }
}