package com.algorithm.dataStructure.bit.bitmap;

import com.algorithm.util.MemoryUtils;

/**
 * 真正基于位存储、操作的位图
 *
 * @author dragonsong  @date 2022/7/14
 * @see BooleanArrayBitMap 中基于boolean数组，一个boolean就占用一个字节，一个字节中有8位，对于表达二值其实有7位是浪费的
 */
public class RealBitMap {

    /*
     * 执行 333331423次set操作，共耗时：8762 ms
     * RealBitMap 10 亿容量 一共占用29.802326202392578 MB
     *
     * 操作大致量级的set时，耗时与 BooleanArrayBitMap 接近，而内存占用却节省了 三十倍！
     */

    /**
     * 位图容量
     */
    int capacity;
    /**
     * 存储数组
     * char占用16位，一个char可表达16个二值
     */
    char[] arr;

    public RealBitMap(int capacity) {
        this.capacity = capacity;
        // capacity % 16 有余数才需要增加一个char存储
        this.arr = new char[capacity % 16 == 0 ? capacity / 16 : capacity / 16 + 1];
    }

    public void set(int i) {
        assert i < capacity && i >= 0;
        // 商命中实际存储的数组下标
        int quotient = i / 16;
        // 余数命中实际操作的位
        int remainder = i % 16;
        // 将1存到 remainder 位置
        arr[quotient] |= (1 << remainder);
    }

    public boolean get(int i) {
        assert i < capacity && i >= 0;
        // 商命中实际存储的数组下标
        int quotient = i / 16;
        // 余数命中实际操作的位
        int remainder = i % 16;
        return (arr[quotient] & (1 << remainder)) != 0;
    }

    public void printMemoryInMB() {
        System.out.println("RealBitMap " + capacity / 100000000 + " 亿容量 一共占用" + MemoryUtils.byte2MB((double) arr.length / 2 + 4) + " MB");
    }

}
