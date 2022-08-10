package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolveTheEquationTest {

    @Test
    public void solveEquation() {
        SolveTheEquation service = new SolveTheEquation();
        assertEquals("x=2", service.solveEquation("x+5-3+x=6+x-2"));
        assertEquals("Infinite solutions", service.solveEquation("x=x"));
        assertEquals("x=0", service.solveEquation("2x=x"));
        assertEquals("No solution", service.solveEquation("x=x+2"));
        assertEquals("x=1", service.solveEquation("-x=-1"));
    }
}