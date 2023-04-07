package com.algorithm.decimal;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindNUniqueIntegersSumUpToZeroTest {

    @Test
    public void sumZero() {
        FindNUniqueIntegersSumUpToZero service = new FindNUniqueIntegersSumUpToZero();
        System.out.println(Arrays.toString(service.sumZero(2)));
        System.out.println(Arrays.toString(service.sumZero(3)));
        System.out.println(Arrays.toString(service.sumZero(4)));
        System.out.println(Arrays.toString(service.sumZero(5)));
        System.out.println(Arrays.toString(service.sumZero(6)));
    }
}