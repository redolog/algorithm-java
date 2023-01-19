package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StrongPasswordCheckerIITest {

    @Test
    public void strongPasswordCheckerII() {
        StrongPasswordCheckerII service = new StrongPasswordCheckerII();
        assertTrue(service.strongPasswordCheckerII("IloveLe3tcode!"));
        assertFalse(service.strongPasswordCheckerII("Me+You--IsMyDream"));
        assertFalse(service.strongPasswordCheckerII("1aB!"));
    }
}