package com.algorithm.dataStructure.bit.bitmap;

import com.algorithm.util.MemoryUtils;

/**
 * 基于 boolean 数组实现的位图
 * <p>
 * 类型名称	关键字	占用内存	取值范围
 * 字节型	byte	1 字节	-128~127
 * 短整型	short	2 字节	-32768~32767
 * 整型	int	4 字节	-2147483648~2147483647
 * 长整型	long	8 字节	-9223372036854775808L~9223372036854775807L
 * 单精度浮点型	float	4 字节	+/-3.4E+38F（6~7 个有效位）
 * 双精度浮点型	double	8 字节	+/-1.8E+308 (15 个有效位）
 * 字符型	char	2 字节	ISO 单一字符集
 * 布尔型	boolean	1 字节	true 或 false
 *
 * @author dragonsong  @date 2022/7/14
 */
public class BooleanArrayBitMap {
    /*
     * java语言中的boolean占一个字节
     * 实测：
     * 执行 333335874次set操作，共耗时：8170 ms
     * BooleanArrayBitMap 10 亿容量 一共占用953.6743202209473 MB
     *
     * 而表达位图中的二值，仅需要一个位，即可
     */

    /**
     * 位图容量
     */
    int capacity;
    /**
     * 存储数组
     */
    boolean[] arr;

    public BooleanArrayBitMap(int capacity) {
        this.capacity = capacity;
        this.arr = new boolean[capacity];
    }

    public void set(int i) {
        assert i < capacity && i >= 0;
        arr[i] = true;
    }

    public boolean get(int i) {
        assert i < capacity && i >= 0;
        return arr[i];
    }

    public void printMemoryInMB() {
        System.out.println("BooleanArrayBitMap " + capacity / 100000000 + " 亿容量 一共占用" + MemoryUtils.byte2MB(capacity + 4) + " MB");
    }
}
