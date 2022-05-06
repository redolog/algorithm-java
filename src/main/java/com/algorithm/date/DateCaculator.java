package com.algorithm.date;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Given a specific date, write a function to return the day of the year for that date. The signature of the function is
 * <p>
 * int dayOfYear(int year, int month, int day)
 * <p>
 * <p>
 * For example, given input of year=2016, month=1, day=3. The function should return 3 as the date 2016-01-03 is the 3rd day of the year 2016.
 * <p>
 * Another example, given input of year=2016, month=2, day=1. The function should return 32 as the date 2016-02-01 is the 32nd day of the year 2016.
 * <p>
 * <p>
 * Notes:
 * <p>
 * Please return -1 for invalid input.
 * <p>
 * Please write your own algorithm. Do NOT use any class like Calendar in Java.
 * <p>
 * Please give a full implementation. Do NOT write pseudo code.
 * <p>
 * Please include your own logic of determining a leap year.
 * <p>
 * You are free to choose any programming language, not limited to Java, C# or C++. Please tell us the programming language you used in your answer.
 *
 * @author dragonsong  @date 2022/5/6
 */
public class DateCaculator {

    private static final List<Integer> MONTH_31_DAY = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
//    private static final List<Integer> MONTH_30_DAY = Arrays.asList(4, 6, 9, 11);

    public static final int MONTH_FEB = 2;


    public static int daysOfMonth(int year, int month) {
        if (month == MONTH_FEB) {
            return isLeapYear(year) ? 29 : 28;
        }
        return MONTH_31_DAY.contains(month) ? 31 : 30;
    }

    public static int dayOfYear(int year, int month, int day) {
        if (isInvalidMonth(month)) {
            return -1;
        }

        int monthDays = daysOfMonth(year, month);
        if (day > monthDays) {
            return -1;
        }

        if (month == 1) {
            return day;
        }

        OptionalInt sumOp = IntStream.range(1, month)
                .map(currentMonth -> daysOfMonth(year, currentMonth))
                .reduce(Integer::sum);

        if (!sumOp.isPresent()) {
            return -1;
        }
        return sumOp.getAsInt() + day;
    }

    private static boolean isInvalidMonth(int month) {
        return month < 1 || month > 12;
    }

    /**
     * To be a leap year, the year number must be divisible by four
     * – except for end-of-century years, which must be divisible by 400.
     * This means that the year 2000 was a leap year, although 1900 was not.
     *
     * @return true if param is a leap year
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 400 == 0) {
            return true;
        }
        return year % 100 != 0;
    }
}
