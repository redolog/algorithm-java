package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsomorphicStringsTest {

    @Test
    public void isIsomorphic() {
        IsomorphicStrings.TwoMap twoMap = new IsomorphicStrings.TwoMap();
        assertTrue(twoMap.isIsomorphic("add", "egg"));
        assertTrue(twoMap.isIsomorphic("paper", "title"));
        assertFalse(twoMap.isIsomorphic("foo", "bar"));
        IsomorphicStrings.OneMap oneMap = new IsomorphicStrings.OneMap();
        assertTrue(oneMap.isIsomorphic("add", "egg"));
        assertTrue(oneMap.isIsomorphic("paper", "title"));
        assertFalse(oneMap.isIsomorphic("foo", "bar"));
    }
}