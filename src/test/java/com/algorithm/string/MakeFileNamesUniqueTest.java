package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MakeFileNamesUniqueTest {

    @Test
    public void getFolderNames() {
        MakeFileNamesUnique service = new MakeFileNamesUnique();
        assertArrayEquals(new String[]{"pes", "fifa", "gta", "pes(2019)"}, service.getFolderNames(new String[]{"pes", "fifa", "gta", "pes(2019)"}));
        assertArrayEquals(new String[]{"gta", "gta(1)", "gta(2)", "avalon"}, service.getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"}));
        assertArrayEquals(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"}, service.getFolderNames(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"}));
        assertArrayEquals(new String[]{"wano", "wano(1)", "wano(2)", "wano(3)"}, service.getFolderNames(new String[]{"wano", "wano", "wano", "wano"}));
        assertArrayEquals(new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"}, service.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"}));
    }
}