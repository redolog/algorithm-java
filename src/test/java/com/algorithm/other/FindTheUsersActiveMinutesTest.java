package com.algorithm.other;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindTheUsersActiveMinutesTest {

    FindTheUsersActiveMinutes service = new FindTheUsersActiveMinutes();

    @Test
    public void findingUsersActiveMinutes() {

        assertArrayEquals(new int[]{0, 2, 0, 0, 0}, service.findingUsersActiveMinutes(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5));
        assertArrayEquals(new int[]{1, 1, 0, 0}, service.findingUsersActiveMinutes(new int[][]{{1, 1}, {2, 2}, {2, 3}}, 4));

    }
}