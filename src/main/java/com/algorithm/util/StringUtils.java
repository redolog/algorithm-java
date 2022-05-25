package com.algorithm.util;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean equals(String str1, String str2) {
        return isEmpty(str1) ? isEmpty(str2) : str1.equals(str2);
    }

    public static boolean isEmpty(String str) {
        return null == str || str.length() == 0;
    }
}
