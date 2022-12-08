package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DetermineColorOfAChessboardSquareTest {

    @Test
    public void squareIsWhite() {
        DetermineColorOfAChessboardSquare service = new DetermineColorOfAChessboardSquare();
        assertFalse(service.squareIsWhite("a1"));
        assertFalse(service.squareIsWhite("c7"));
        assertTrue(service.squareIsWhite("h3"));
        assertFalse(service.squareIsWhite2("a1"));
        assertFalse(service.squareIsWhite2("c7"));
        assertTrue(service.squareIsWhite2("h3"));
    }
}