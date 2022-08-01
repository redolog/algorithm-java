package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReplaceAllSToAvoidConsecutiveRepeatingCharactersTest {

    @Test
    public void modifyString() {
        ReplaceAllSToAvoidConsecutiveRepeatingCharacters service = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters();
        assertEquals("azs", service.modifyString("?zs"));
        assertEquals("ubvaw", service.modifyString("ubv?w"));
        assertEquals("jaqgacb", service.modifyString("j?qg??b"));
    }
}