package com.algorithm.util;

public class AssertUtils {

    private AssertUtils(){}

    public static int checkNonnegative(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
        }
        return value;
    }
}
