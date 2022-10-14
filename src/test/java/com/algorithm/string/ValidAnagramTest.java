package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidAnagramTest {

    @Test
    public void isAnagram() {
        ValidAnagram.SortSolution sortSolution = new ValidAnagram.SortSolution();
        assertTrue(sortSolution.isAnagram("anagram", "nagaram"));
        assertFalse(sortSolution.isAnagram("rat", "car"));
        ValidAnagram.CntSolution cntSolution = new ValidAnagram.CntSolution();
        assertTrue(cntSolution.isAnagram("anagram", "nagaram"));
        assertFalse(cntSolution.isAnagram("rat", "car"));
    }
}