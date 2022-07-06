package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstUniqueCharTest {
    FirstUniqueChar service = new FirstUniqueChar();

    @Test
    public void firstUniqChar() {

        assertEquals('b', service.firstUniqChar("abaccdeff"));
        assertEquals(' ', service.firstUniqChar(""));
        assertEquals('z', service.firstUniqChar("z"));
    }

    @Test
    public void firstUniqChar2() {
        assertEquals('b', service.firstUniqChar2("abaccdeff"));
        assertEquals(' ', service.firstUniqChar2(""));
        assertEquals('z', service.firstUniqChar2("z"));
        assertEquals(' ', service.firstUniqChar2("aadadaad"));
    }
}