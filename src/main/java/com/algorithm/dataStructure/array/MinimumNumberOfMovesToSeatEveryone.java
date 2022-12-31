package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/
 *
 * @author songhuilong001  @date 2022/12/31
 */
public class MinimumNumberOfMovesToSeatEveryone {

    /**
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(logn)
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0, n = seats.length;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(students[i] - seats[i]);
        }
        return ans;
    }
}
