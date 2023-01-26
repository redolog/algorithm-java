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
        GreatestEnglishLetterInUpperAndLowerCase.ArrCntSolution arrCntSolution = new GreatestEnglishLetterInUpperAndLowerCase.ArrCntSolution();
        assertEquals("E", arrCntSolution.greatestLetter("lEeTcOdE"));
        assertEquals("R", arrCntSolution.greatestLetter("arRAzFif"));
        assertEquals("", arrCntSolution.greatestLetter("AbCdEfGhIjK"));
        GreatestEnglishLetterInUpperAndLowerCase.BitSolution2 bitSolution2 = new GreatestEnglishLetterInUpperAndLowerCase.BitSolution2();
        assertEquals("E", bitSolution2.greatestLetter("lEeTcOdE"));
        assertEquals("R", bitSolution2.greatestLetter("arRAzFif"));
        assertEquals("", bitSolution2.greatestLetter("AbCdEfGhIjK"));
    }
}