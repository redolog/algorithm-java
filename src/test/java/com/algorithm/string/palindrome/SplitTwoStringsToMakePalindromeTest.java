package com.algorithm.string.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SplitTwoStringsToMakePalindromeTest {

    @Test
    public void checkPalindromeFormation() {
        SplitTwoStringsToMakePalindrome service = new SplitTwoStringsToMakePalindrome();
        assertTrue(service.checkPalindromeFormation("x", "y"));
        assertTrue(service.checkPalindromeFormation("abdef", "fecab"));
        assertTrue(service.checkPalindromeFormation("ulacfd", "jizalu"));
        assertTrue(service.checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
        assertTrue(service.checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
    }
}
