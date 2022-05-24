package com.algorithm.bit;

public class PrintNumBit32 {

    /**
     * 给定一个int，打印32位下，0或者1的状态
     */
    public static void printNumBit32(int num) {

        /*
         * 左移：无符号 <<
         * num左移n位，则32位表示下，向左移动n位，右侧补0
         * 1 << i 位，表示32位下i位为1
         *
         * 与 &
         * 32位下，两位相同为1，否则为0
         *
         * 取反 ~
         * 0变1 ， 1变0
         *
         * 正数符号位0
         * 负数符号位1
         * 负数计算：根据符号位判断为负数，计算数值位，取反之后+1
         * 所以 - == ~ +1
         *
         * 右移：
         * >> 带符号右移，数值位右移后，最左填充符号位
         * >>> 不带符号右移，数值位右移后，最左填充0
         */
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & 1 << i) == 0 ? '0' : '1');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 2382834;
        int b = 1334;

        printNumBit32(a);
//        printNumBit32(~a);
//        printNumBit32(b);
//
//        printNumBit32(a & b);
//        printNumBit32(a | b);
//        printNumBit32(a ^ b);
//
//        printNumBit32(0);
    }
}
