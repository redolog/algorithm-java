package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LongPressedNameTest {

    @Test
    public void isLongPressedName() {
        LongPressedName service = new LongPressedName();
        assertTrue(service.isLongPressedName("alex", "aaleex"));
        assertFalse(service.isLongPressedName("alex", "aaleexa"));
        assertFalse(service.isLongPressedName("alex", "aaleexeex"));
        assertFalse(service.isLongPressedName("saeed", "ssaaedd"));
        assertFalse(service.isLongPressedName("pyplrz", "ppyypllr"));
    }
}