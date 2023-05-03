package com.algorithm.dataStructure.stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfWordIsValidAfterSubstitutionsTest {

    @Test
    public void test() {
        CheckIfWordIsValidAfterSubstitutions.Match3Solution rollbackSolution = new CheckIfWordIsValidAfterSubstitutions.Match3Solution();
        assertTrue(rollbackSolution.isValid("aabcbc"));
        assertTrue(rollbackSolution.isValid("abcabcababcc"));
        assertFalse(rollbackSolution.isValid("abccba"));
        CheckIfWordIsValidAfterSubstitutions.ParenthesesMatchSolution parenthesesMatchSolution = new CheckIfWordIsValidAfterSubstitutions.ParenthesesMatchSolution();
        assertTrue(parenthesesMatchSolution.isValid("aabcbc"));
        assertTrue(parenthesesMatchSolution.isValid("abcabcababcc"));
        assertFalse(parenthesesMatchSolution.isValid("abccba"));
    }

}