package com.algorithm.string.subSequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RearrangeCharactersToMakeTargetStringTest {

    @Test
    public void rearrangeCharacters() {
        RearrangeCharactersToMakeTargetString.ArrCountSolution arrCountSolution = new RearrangeCharactersToMakeTargetString.ArrCountSolution();
        assertEquals(2, arrCountSolution.rearrangeCharacters("ilovecodingonleetcode", "code"));
        assertEquals(1, arrCountSolution.rearrangeCharacters("abcba", "abc"));
        assertEquals(1, arrCountSolution.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
        RearrangeCharactersToMakeTargetString.StreamSolution streamSolution = new RearrangeCharactersToMakeTargetString.StreamSolution();
        assertEquals(2, streamSolution.rearrangeCharacters("ilovecodingonleetcode", "code"));
        assertEquals(1, streamSolution.rearrangeCharacters("abcba", "abc"));
        assertEquals(1, streamSolution.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
    }
}