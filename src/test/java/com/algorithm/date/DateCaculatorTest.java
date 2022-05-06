package com.algorithm.date;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateCaculatorTest {

    @Test
    public void isLeapYear() {

        assertFalse(DateCaculator.isLeapYear(1900));
        assertFalse(DateCaculator.isLeapYear(1800));
        assertFalse(DateCaculator.isLeapYear(1811));
        assertTrue(DateCaculator.isLeapYear(2000));
        assertTrue(DateCaculator.isLeapYear(2020));
        assertTrue(DateCaculator.isLeapYear(2024));
    }

    @Test
    public void dayOfYear() {
        assertEquals(3, DateCaculator.dayOfYear(2016, 1, 3));
        assertEquals(32, DateCaculator.dayOfYear(2016, 2, 1));
        assertEquals(61, DateCaculator.dayOfYear(2000, 3, 1));
        assertEquals(-1, DateCaculator.dayOfYear(2016, 13, 1));
        assertEquals(-1, DateCaculator.dayOfYear(2000, 3, 32));
        assertEquals(-1, DateCaculator.dayOfYear(2000, 2, 30));
    }
}