package com.algorithm.dataStructure.array.diff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfStudentsDoingHomeworkAtAGivenTimeTest {

    @Test
    public void testBusyStudent() {
        NumberOfStudentsDoingHomeworkAtAGivenTime service = new NumberOfStudentsDoingHomeworkAtAGivenTime();
        assertEquals(1, service.busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));
        assertEquals(1, service.busyStudent(new int[]{4}, new int[]{4}, 4));
        assertEquals(0, service.busyStudent(new int[]{4}, new int[]{4}, 5));
        assertEquals(0, service.busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7));
        assertEquals(5, service.busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5));

        NumberOfStudentsDoingHomeworkAtAGivenTime.BSearch bSearch = new NumberOfStudentsDoingHomeworkAtAGivenTime.BSearch();
        assertEquals(1, bSearch.busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));
        assertEquals(1, bSearch.busyStudent(new int[]{4}, new int[]{4}, 4));
        assertEquals(0, bSearch.busyStudent(new int[]{4}, new int[]{4}, 5));
        assertEquals(0, bSearch.busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7));
        assertEquals(5, bSearch.busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5));

        NumberOfStudentsDoingHomeworkAtAGivenTime.DiffArr diffArr = new NumberOfStudentsDoingHomeworkAtAGivenTime.DiffArr();
        assertEquals(1, diffArr.busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));
        assertEquals(1, diffArr.busyStudent(new int[]{4}, new int[]{4}, 4));
        assertEquals(0, diffArr.busyStudent(new int[]{4}, new int[]{4}, 5));
        assertEquals(0, diffArr.busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7));
        assertEquals(5, diffArr.busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5));

    }
}