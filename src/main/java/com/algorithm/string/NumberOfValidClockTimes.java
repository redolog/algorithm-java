package com.algorithm.string;

/**
 * https://leetcode.cn/problems/number-of-valid-clock-times/
 *
 * @author songhuilong001  @date 2023/5/9
 */
public class NumberOfValidClockTimes {

    public int countTime(String time) {
        int hhCnt = hhCnt(time.substring(0, 2));
        int mmCnt = mmCnt(time.substring(3, 5));
        return hhCnt * mmCnt;
    }

    private int hhCnt(String hh) {
        if (!hh.contains("?")) {
            return 1;
        }
        if ("??".equals(hh)) {
            return 24;
        }
        if (hh.charAt(0) == '?') {
            int h2 = hh.charAt(1) - '0';
            return h2 < 4 ? 3 : 2;
        }
        if (hh.charAt(0) == '0') {
            return 10;
        }
        if (hh.charAt(0) == '1') {
            return 10;
        }
        return 4;
    }

    private int mmCnt(String mm) {
        if (!mm.contains("?")) {
            return 1;
        }
        if ("??".equals(mm)) {
            return 60;
        }
        if (mm.charAt(0) == '?') {
            return 6;
        }
        return 10;
    }
}
