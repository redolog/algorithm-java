package com.algorithm.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetcodeLeaderboardTest {

    @Test
    public void testLeaderboard() {
        LeetcodeLeaderboard.Leaderboard leaderboard = new LeetcodeLeaderboard.Leaderboard();
        leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        assertEquals(73, leaderboard.top(1));           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        assertEquals(141, leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
    }

}