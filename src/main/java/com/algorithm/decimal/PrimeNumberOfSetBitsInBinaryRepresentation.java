package com.algorithm.decimal;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/
 *
 * @author songhuilong  @date 2022/12/20
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primes = Arrays.stream(new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31}).collect(Collectors.toSet());
        return (int) IntStream.rangeClosed(left, right).filter(num -> primes.contains(Integer.bitCount(num))).count();
    }
}
