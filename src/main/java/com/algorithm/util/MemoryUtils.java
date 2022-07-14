package com.algorithm.util;

/**
 * 内存单位转换
 *
 * @author dragonsong  @date 2022/7/14
 */
public class MemoryUtils {

    private MemoryUtils() {
    }

    public static double byte2TB(double bytes) {
        return byte2Terabyte(bytes);
    }

    public static double byte2Terabyte(double bytes) {
        return byte2Gigabyte(bytes) / 1024;
    }

    public static double byte2GB(double bytes) {
        return byte2Gigabyte(bytes);
    }

    public static double byte2Gigabyte(double bytes) {
        return byte2Megabyte(bytes) / 1024;
    }

    public static double byte2MB(double bytes) {
        return byte2Megabyte(bytes);
    }

    public static double byte2Megabyte(double bytes) {
        return byte2Kilobyte(bytes) / 1024;
    }

    public static double byte2KB(double bytes) {
        return byte2Kilobyte(bytes);
    }

    public static double byte2Kilobyte(double bytes) {
        return bytes / 1024;
    }
}
