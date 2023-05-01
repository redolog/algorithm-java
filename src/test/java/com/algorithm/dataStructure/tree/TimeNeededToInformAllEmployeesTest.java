package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeNeededToInformAllEmployeesTest {

    @Test
    public void numOfMinutes() {
        TimeNeededToInformAllEmployees service = new TimeNeededToInformAllEmployees();
        assertEquals(0, service.numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
        assertEquals(1, service.numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}));
        assertEquals(2600, service.numOfMinutes(13, 0, new int[]{-1, 6, 6, 7, 12, 1, 0, 0, 12, 0, 2, 6, 11}, new int[]{567, 670, 351, 0, 0, 0, 573, 17, 0, 0, 0, 594, 866}));
    }
}