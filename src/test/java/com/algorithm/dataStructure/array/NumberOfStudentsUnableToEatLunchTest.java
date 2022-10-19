package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfStudentsUnableToEatLunchTest {

    @Test
    public void countStudents() {
        NumberOfStudentsUnableToEatLunch service = new NumberOfStudentsUnableToEatLunch();
        assertEquals(0, service.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        assertEquals(3, service.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}