package com.algorithm.string;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReformatTheStringTest {

    @Test
    public void reformat() {
        ReformatTheString service = new ReformatTheString();
        assertEquals("0a1b2c", service.reformat("a0b1c2"));
        assertEquals("", service.reformat("leetcode"));
        assertEquals("", service.reformat("1229857369"));
        assertEquals("c2o0v1i9d", service.reformat("covid2019"));

        ReformatTheString.TwoPointer twoPointer = new ReformatTheString.TwoPointer();
        assertEquals("0a1b2c", twoPointer.reformat("a0b1c2"));
        assertEquals("", twoPointer.reformat("leetcode"));
        assertEquals("", twoPointer.reformat("1229857369"));
        assertTrue(Objects.equals("c2o0v1i9d", twoPointer.reformat("covid2019")) || Objects.equals("c0v9d2o1i", twoPointer.reformat("covid2019")));
    }
}