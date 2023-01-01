package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstLetterToAppearTwiceTest {

    @Test
    public void repeatedCharacter() {
        FirstLetterToAppearTwice.MapSolution mapSolution = new FirstLetterToAppearTwice.MapSolution();
        assertEquals('c', mapSolution.repeatedCharacter("abccbaacz"));
        assertEquals('d', mapSolution.repeatedCharacter("abcdd"));
        FirstLetterToAppearTwice.BitSolution bitSolution = new FirstLetterToAppearTwice.BitSolution();
        assertEquals('c', bitSolution.repeatedCharacter("abccbaacz"));
        assertEquals('d', bitSolution.repeatedCharacter("abcdd"));
    }
}