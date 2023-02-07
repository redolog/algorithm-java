package com.algorithm.dataStructure.array.app.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriodTest {

    @Test
    public void alertNames() {
        AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod service = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod();
        assertEquals(Collections.singletonList("daniel"), service.alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
        assertEquals(Collections.singletonList("bob"), service.alertNames(new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"}, new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"}));
        assertEquals(Collections.emptyList(), service.alertNames(new String[]{"john", "john", "john"}, new String[]{"23:58", "23:59", "00:01"}));
        assertEquals(Arrays.asList("clare", "leslie"), service.alertNames(new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"}, new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}));
    }
}