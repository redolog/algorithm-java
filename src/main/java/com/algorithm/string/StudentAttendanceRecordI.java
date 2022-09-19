package com.algorithm.string;

/**
 * https://leetcode.cn/problems/student-attendance-record-i/
 *
 * @author songhuilong  @date 2022/9/19
 */
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int aCnt = 0, lContinuousCnt = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                aCnt++;
            }
            if (aCnt >= 2) {
                return false;
            }
            if (s.charAt(i) != 'L') {
                lContinuousCnt = 0;
            } else {
                lContinuousCnt++;
            }
            if (lContinuousCnt >= 3) {
                return false;
            }
        }
        return true;
    }
}
