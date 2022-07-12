package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SqrtXTest {

    @Test
    public void mySqrt() {
        SqrtX service = new SqrtX();
        assertEquals(2, service.mySqrt(4));
        assertEquals(1, service.mySqrt(3));
        assertEquals(2, service.mySqrt(8));
        assertEquals(2, service.mySqrt(6));
        assertEquals(3, service.mySqrt(9));
        assertEquals(1, service.mySqrt(1));
        assertEquals(0, service.mySqrt(0));
    }
}