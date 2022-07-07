package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Decimal2BinaryTest {

    @Test
    public void decimal2BinaryStr() {
        String ans5 = Decimal2Binary.decimal2BinaryStr(5, "");
        assertEquals("0101", ans5);
        String ans2 = Decimal2Binary.decimal2BinaryStr(2, "");
        assertEquals("010", ans2);
        String ans1024 = Decimal2Binary.decimal2BinaryStr(1024, "");
        assertEquals("010000000000", ans1024);

        ans5 = Decimal2Binary.Traversal.decimal2BinaryStr(5, "");
        assertEquals("0101", ans5);
        ans2 = Decimal2Binary.Traversal.decimal2BinaryStr(2, "");
        assertEquals("010", ans2);
        ans1024 = Decimal2Binary.Traversal.decimal2BinaryStr(1024, "");
        assertEquals("010000000000", ans1024);
    }
}