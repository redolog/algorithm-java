package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentAttendanceRecordITest {

    @Test
    public void checkRecord() {
        StudentAttendanceRecordI service = new StudentAttendanceRecordI();
        assertTrue(service.checkRecord("PPALLP"));
        assertFalse(service.checkRecord("PPALLL"));
    }
}