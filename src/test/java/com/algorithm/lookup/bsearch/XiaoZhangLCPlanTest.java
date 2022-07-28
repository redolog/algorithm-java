package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XiaoZhangLCPlanTest {

    @Test
    public void minTime() {
        XiaoZhangLCPlan service = new XiaoZhangLCPlan();
        int[] time1 = {1, 2, 3, 3};
        int[] time2 = {999, 999, 999};
        int[] time3 = {1, 2, 3, 3, 3};
        int[] time4 = {50, 47, 68, 33, 35, 84, 25, 49, 91, 75};
        int[] time5 = {1, 2, 7, 4, 7};
        int[] time6 = {1, 2, 7, 4, 7, 7};
        int[] time7 = {94, 92, 90, 57, 6, 89, 63, 15, 91, 74};
        assertEquals(3, service.minTime(time1, 2));
        assertEquals(0, service.minTime(time2, 4));
        assertEquals(3, service.minTime(time3, 2));
        assertEquals(466, service.minTime(time4, 1));
        assertEquals(4, service.minTime(time5, 2));
        assertEquals(7, service.minTime(time6, 2));
        assertEquals(63, service.minTime(time7, 6));

        System.out.println(service.speed2Time(240, time4));
        System.out.println(service.speed2Time(465, time4));
        System.out.println(service.speed2Time(466, time4));
        System.out.println(service.speed2Time(482, time4));
        System.out.println(service.speed2Time(4, time5));
        System.out.println(service.speed2Time(7, time6));
        System.out.println(service.speed2Time(63, time7));
    }
}