package com.algorithm.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StrStrTest {

    StrStr service;

    @Before
    public void setUp() throws Exception {
        service = new StrStr();
    }

    @Test
    public void strStr() {
        Assert.assertEquals(2, service.strStr("hello", "ll"));
        Assert.assertEquals(-1, service.strStr("aaaaa", "bba"));
    }
}