package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReversePrefixOfWordTest {

    @Test
    public void reversePrefix() {
        ReversePrefixOfWord service = new ReversePrefixOfWord();
        assertEquals("abcd", service.reversePrefix("abcd", 'z'));
        assertEquals("dcbaefd", service.reversePrefix("abcdefd", 'd'));
        assertEquals("zxyxxe", service.reversePrefix("xyxzxe", 'z'));

        ReversePrefixOfWord.BuilderSolution builderSolution = new ReversePrefixOfWord.BuilderSolution();
        assertEquals("abcd", builderSolution.reversePrefix("abcd", 'z'));
        assertEquals("dcbaefd", builderSolution.reversePrefix("abcdefd", 'd'));
        assertEquals("zxyxxe", builderSolution.reversePrefix("xyxzxe", 'z'));
    }
}