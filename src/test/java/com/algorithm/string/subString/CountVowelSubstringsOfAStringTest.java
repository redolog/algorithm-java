package com.algorithm.string.subString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountVowelSubstringsOfAStringTest {

    @Test
    public void countVowelSubstrings() {
        CountVowelSubstringsOfAString.SetSolution setSolution = new CountVowelSubstringsOfAString.SetSolution();
        assertEquals(2, setSolution.countVowelSubstrings("aeiouu"));
        assertEquals(0, setSolution.countVowelSubstrings("unicornarihan"));
        assertEquals(7, setSolution.countVowelSubstrings("cuaieuouac"));
        assertEquals(0, setSolution.countVowelSubstrings("bbaeixoubb"));
    }
}