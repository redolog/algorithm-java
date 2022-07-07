package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base7Test {

    @Test
    public void convertToBase7() {
        Base7.Traversal traversal = new Base7.Traversal();
        assertEquals("202", traversal.convertToBase7(100));
        assertEquals("-10", traversal.convertToBase7(-7));
        assertEquals("-11", traversal.convertToBase7(-8));

        Base7.Recursion recursion = new Base7.Recursion();
        assertEquals("202", recursion.convertToBase7(100));
        assertEquals("-10", recursion.convertToBase7(-7));
        assertEquals("-11", recursion.convertToBase7(-8));

    }
}