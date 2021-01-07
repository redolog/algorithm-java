package com.algorithm.dataStructure.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimplifyPathTest {

    SimplifyPath service;

    @Before
    public void setUp() throws Exception {
        service = new SimplifyPath();
    }

    @Test
    public void simplifyPath() {
        assertEquals("/home", service.simplifyPath("/home/"));
        assertEquals("/", service.simplifyPath("/../"));
        assertEquals("/home/foo", service.simplifyPath("/home//foo/"));
        assertEquals("/c", service.simplifyPath("/a/./b/../../c/"));
        assertEquals("/c", service.simplifyPath("/a/../../b/../c//.//"));
        assertEquals("/a/b/c", service.simplifyPath("/a//b////c/d//././/.."));
    }
}