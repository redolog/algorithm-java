package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReformatPhoneNumberTest {

    @Test
    public void reformatNumber() {
        ReformatPhoneNumber service = new ReformatPhoneNumber();
        assertEquals("123-456", service.reformatNumber("1-23-45 6"));
        assertEquals("123-45-67", service.reformatNumber("123 4-567"));
        assertEquals("123-456-78", service.reformatNumber("123 4-5678"));
        assertEquals("12", service.reformatNumber("12"));
        assertEquals("175-229-353-94-75", service.reformatNumber("--17-5 229 35-39475 "));
    }
}