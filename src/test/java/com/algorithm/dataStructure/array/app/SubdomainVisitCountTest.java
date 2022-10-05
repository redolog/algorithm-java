package com.algorithm.dataStructure.array.app;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SubdomainVisitCountTest {

    @Test
    public void subdomainVisits() {
        SubdomainVisitCount.MapSolution mapSolution = new SubdomainVisitCount.MapSolution();
        assertTrue(CollectionUtils.equals(Arrays.asList("9001 leetcode.com", "9001 discuss.leetcode.com", "9001 com"), mapSolution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com", "951 com"), mapSolution.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"})));
        SubdomainVisitCount.TrieSolution trieSolution = new SubdomainVisitCount.TrieSolution();
        assertTrue(CollectionUtils.equals(Arrays.asList("9001 leetcode.com", "9001 discuss.leetcode.com", "9001 com"), trieSolution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com", "951 com"), trieSolution.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"})));
    }
}