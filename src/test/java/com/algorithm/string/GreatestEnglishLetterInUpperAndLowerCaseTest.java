package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreatestEnglishLetterInUpperAndLowerCaseTest {

    @Test
    public void greatestLetter() {
        GreatestEnglishLetterInUpperAndLowerCase.SetSolution setSolution = new GreatestEnglishLetterInUpperAndLowerCase.SetSolution();
        assertEquals("E", setSolution.greatestLetter("lEeTcOdE"));
        assertEquals("R", setSolution.greatestLetter("arRAzFif"));
        assertEquals("", setSolution.greatestLetter("AbCdEfGhIjK"));
        GreatestEnglishLetterInUpperAndLowerCase.BitSolution bitSolution = new GreatestEnglishLetterInUpperAndLowerCase.BitSolution();
        assertEquals("E", bitSolution.greatestLetter("lEeTcOdE"));
        assertEquals("R", bitSolution.greatestLetter("arRAzFif"));
        assertEquals("", bitSolution.greatestLetter("AbCdEfGhIjK"));
    }
}