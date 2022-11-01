package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SplitAStringInBalancedStringsTest {

    @Test
    public void balancedStringSplit() {
        SplitAStringInBalancedStrings service = new SplitAStringInBalancedStrings();
        assertEquals(4, service.balancedStringSplit("RLRRLLRLRL"));
        assertEquals(3, service.balancedStringSplit("RLLLLRRRLR"));
        assertEquals(1, service.balancedStringSplit("LLLLRRRR"));
        assertEquals(2, service.balancedStringSplit("RLRRRLLRLL"));
        assertEquals(4, service.balancedStringSplit2("RLRRLLRLRL"));
        assertEquals(3, service.balancedStringSplit2("RLLLLRRRLR"));
        assertEquals(1, service.balancedStringSplit2("LLLLRRRR"));
        assertEquals(2, service.balancedStringSplit2("RLRRRLLRLL"));
    }
}