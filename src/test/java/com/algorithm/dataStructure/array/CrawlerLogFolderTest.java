package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrawlerLogFolderTest {

    @Test
    public void testCrawlerLogFolder() {
        CrawlerLogFolder service = new CrawlerLogFolder();
        assertEquals(2, service.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        assertEquals(3, service.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        assertEquals(0, service.minOperations(new String[]{"d1/", "../", "../", "../"}));
    }

}