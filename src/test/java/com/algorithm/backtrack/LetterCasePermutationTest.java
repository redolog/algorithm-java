package com.algorithm.backtrack;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class LetterCasePermutationTest {

    @Test
    public void letterCasePermutation() {
        LetterCasePermutation service = new LetterCasePermutation();
        assertTrue(CollectionUtils.equals(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2"), service.letterCasePermutation("a1b2")));
        assertTrue(CollectionUtils.equals(Arrays.asList("3z4", "3Z4"), service.letterCasePermutation("3z4")));
        assertTrue(CollectionUtils.equals(Arrays.asList("c", "C"), service.letterCasePermutation("C")));

        assertTrue(CollectionUtils.equals(Arrays.asList("jCtnPT1asvc",
                "jctNPt1aSvC",
                "JCtnpT1ASVc",
                "JCtnpT1AsVC",
                "JCTnpT1aSvC",
                "jCTNpT1ASvC",
                "jCtNPT1aSvC",
                "jctnPt1ASVC",
                "jcTNpt1asVC",
                "jcTNpt1aSVc",
                "jCtnPT1ASVC",
                "jCTNpT1aSVc",
                "JcTNPT1ASVc",
                "JcTNPT1AsVC",
                "jCTNpT1asVC",
                "JctNpt1asvc",
                "JCtNpT1asvc",
                "Jctnpt1AsVc",
                "JcTnpt1asvC",
                "JcTnpt1aSvc",
                "jcTNpt1AsvC",
                "jcTNpt1ASvc",
                "JCtnpT1ASVC",
                "jCTNpT1AsvC",
                "jCTNpT1ASvc",
                "JctNpt1ASVC",
                "JcTNPT1asvc",
                "jcTnPt1aSvC",
                "jctnPt1ASVc",
                "jctnPt1AsVC",
                "jcTNpt1aSVC",
                "JCtNpT1ASVC",
                "jCtnPT1ASVc",
                "jCtnPT1AsVC",
                "jCTnPT1aSvC",
                "jCTNpT1aSVC",
                "JcTNPT1ASVC",
                "JctNpt1asvC",
                "JctNpt1aSvc",
                "jctnPt1asvc",
                "JCtNpT1asvC",
                "JCtNpT1aSvc",
                "JcTnpt1asvc",
                "jcTNpt1ASvC",
                "jCtNpT1asVc",
                "jcTnpt1aSVc",
                "jcTnpt1asVC",
                "JctNpt1ASVc",
                "JctNpt1AsVC",
                "JcTNpt1aSvC",
                "jcTnPt1asvC",
                "jcTnPt1aSvc",
                "JcTnPT1ASVc",
                "JcTnPT1AsVC",
                "jCtNPT1asvc",
                "jctnPt1AsVc",
                "Jctnpt1asvc",
                "JcTnpt1ASVC",
                "jCtnPT1aSvC",
                "jCtNpT1Asvc",
                "jcTnpt1ASvc",
                "JctnPt1aSVC",
                "jcTnpt1AsvC",
                "jCtNPT1ASVC",
                "JCtNpT1aSvC",
                "Jctnpt1ASVC",
                "jCtNpT1aSVc",
                "jCtNpT1asVC",
                "jCtnPT1asvC",
                "jcTnpt1asVc",
                "JctNpt1AsVc",
                "JcTNpt1asvC",
                "JcTNpt1aSvc",
                "jcTnPt1asvc",
                "JcTnPT1AsVc",
                "jCtNPT1asvC",
                "jCtNPT1aSvc",
                "jcTNpt1asVc",
                "jCtnPT1aSvc",
                "jCtNpT1AsvC",
                "jCtNpT1ASvc",
                "JctnPt1aSVc",
                "JctnPt1asVC",
                "JcTNPT1AsVc",
                "jcTnpt1Asvc",
                "Jctnpt1ASVc",
                "Jctnpt1AsVC",
                "jcTnPt1ASVC",
                "JcTnpt1aSvC",
                "jcTNpt1Asvc",
                "jCTnPT1ASVC",
                "jCtnpt1asvC",
                "jCtnpt1aSvc",
                "jCtnpT1asVc",
                "JcTNpt1asvc",
                "Jctnpt1aSvC",
                "jCtnpT1Asvc",
                "JCtnPT1AsvC",
                "JCtnPT1ASvc",
                "JCTNpT1asvc",
                "JcTnpt1AsVc",
                "JctnPt1asVc",
                "jctNPt1AsVc",
                "JCTnpT1AsVc",
                "JcTNpt1ASVC",
                "JCtnPT1asVc",
                "JcTnPT1asvc",
                "jCTNPT1asvC",
                "jCTNPT1aSvc",
                "jcTnPt1ASVc",
                "jcTnPt1AsVC",
                "JCTNpT1ASVC",
                "JCtNPT1aSVC",
                "jCtnpt1aSvC",
                "jcTnpt1aSVC",
                "Jctnpt1aSvc",
                "JcTNpt1AsVC",
                "JcTnPT1ASVC",
                "JCtnPT1ASvC",
                "Jctnpt1asvC",
                "JcTnpt1ASVc",
                "JcTnpt1AsVC",
                "jCtNpt1aSvC",
                "jcTnpt1ASvC",
                "jctNPt1AsVC",
                "JCtNPT1ASvC",
                "jctNPt1ASVc",
                "JCTnpT1ASVc",
                "JCTnpT1AsVC",
                "JcTNpt1ASVc",
                "JcTnPT1aSvc",
                "JcTnPT1asvC",
                "jCTNPT1aSvC",
                "jcTnPt1AsVc",
                "JCTNpT1AsVC",
                "JCTNpT1ASVc",
                "jCTnPT1AsVc",
                "jctNPt1asvc",
                "JCtNPT1aSVc",
                "JCTnpT1asvc",
                "JcTNPT1aSvc",
                "JCtNPT1asVC",
                "JcTNPT1asvC",
                "JcTNpt1AsVc",
                "jCtNpt1asvC",
                "jCTNPT1ASVC",
                "JCTNpT1aSvC",
                "jCtNpt1aSvc",
                "jCTnPT1aSvc",
                "jCtnpt1ASVc",
                "jCTnPT1asvC",
                "JCtNPT1AsvC",
                "JCtNPT1ASvc",
                "jCtnpt1AsVC",
                "jctNPt1ASVC",
                "JCTnpT1ASVC",
                "JctNpt1aSvC",
                "jctnPt1asvC",
                "JCtnPT1aSVC",
                "JcTnPT1aSvC",
                "jctnPt1aSvc",
                "jCTnPT1ASVc",
                "jCTnPT1AsVC",
                "jctNPt1asvC",
                "jctNPt1aSvc",
                "JCTnpT1asvC",
                "JcTNPT1aSvC",
                "jCtnpt1asvc",
                "JCTnpT1aSvc",
                "JCtNPT1asVc",
                "JCtnPT1Asvc",
                "jCtNpt1asvc",
                "jCTNPT1ASVc",
                "JCTNpT1asvC",
                "JCTNpT1aSvc",
                "jCTNPT1AsVC",
                "jCtnpt1ASVC",
                "jCTnPT1asvc",
                "JCtNPT1Asvc",
                "JCtnPT1aSVc",
                "JCtnPT1asVC",
                "jctnPt1aSvC",
                "jCtNpt1ASVC",
                "jCTNPT1asvc",
                "JcTnPt1asVc",
                "jcTNPt1AsVc",
                "JCTnPT1asVc",
                "JCtnpt1ASvC",
                "JcTNPt1aSVC",
                "JcTNPt1ASvC",
                "jcTNpT1AsVc",
                "JCTNPT1aSVC",
                "jCTnpt1asvc",
                "JcTnPt1Asvc",
                "JCtnpt1aSVc",
                "JCTnPT1Asvc",
                "JCtnpt1asVC",
                "jCTNpt1aSvC",
                "jCTnpt1ASVC",
                "JcTnPt1asVC",
                "JcTnPt1aSVc",
                "JCTnPT1aSVc",
                "JCTnPT1asVC",
                "JCtnpt1AsvC",
                "JCtnpt1ASvc",
                "JcTNPt1aSVc",
                "JcTNPt1asVC",
                "JcTNPt1AsvC",
                "JcTNPt1ASvc",
                "JCTNPT1aSVc",
                "jCTnpt1asvC",
                "jCTnpt1aSvc",
                "JCTNPT1asVC",
                "JcTnPt1AsvC",
                "JcTnPt1ASvc",
                "JCtnpt1aSVC",
                "JCTnPT1AsvC",
                "JCTnPT1ASvc",
                "jCTNpt1asvC",
                "jCTNpt1aSvc",
                "jCTnpt1ASVc",
                "JcTnPt1aSVC",
                "jCTnpt1AsVC",
                "jcTNPt1ASVC",
                "JCtnpt1Asvc",
                "JctNPt1AsvC",
                "JctNPt1ASvc",
                "JCTNPT1asVc",
                "JcTnPt1ASvC",
                "JctNPt1asVc",
                "jCTNpt1asvc",
                "JctnPt1Asvc",
                "jcTNPt1AsVC",
                "jCTnpt1AsVc",
                "jcTNPt1ASVc",
                "JCTnpt1aSVC",
                "JctNPt1Asvc",
                "jcTNPt1asvc",
                "JctNPt1asVC",
                "JCtnpt1asVc",
                "JctNPt1aSVc",
                "JCTnpt1ASvC",
                "jctNpT1ASVc",
                "jctNpT1AsVC",
                "jCTNpt1ASVc",
                "jCTNpt1AsVC",
                "JctnPt1ASvc",
                "JctnPt1AsvC",
                "jCtNPt1ASvC",
                "JCtNpt1asVc",
                "JCtNpt1Asvc",
                "JCTnpt1aSVc",
                "JCTnpt1asVC",
                "jCtNPt1aSVc",
                "jCtNPt1asVC",
                "jcTNPt1asvC",
                "jcTNPt1aSvc",
                "JctNPt1aSVC",
                "JCTnpt1AsvC",
                "JCTnpt1ASvc",
                "jctNpT1AsVc",
                "jCTNpt1ASVC",
                "JctnPt1ASvC",
                "jctnpT1AsVc",
                "JCTNPT1Asvc",
                "JCtNpt1aSVc",
                "JCtNpt1asVC",
                "JCtNpt1AsvC",
                "jCtnPt1asVc",
                "JCTnpt1asVc",
                "JctNPt1ASvC",
                "jCtNPt1asVc",
                "jcTNPt1aSvC",
                "JCtNpt1ASvc",
                "jCtnPt1Asvc",
                "JCTnpt1Asvc",
                "jCtNPt1Asvc",
                "JCTNPT1AsvC",
                "JCTNPT1ASvc",
                "JCtNpt1aSVC",
                "jCtnPt1asVC",
                "JCTnPT1aSVC",
                "jCtnPt1aSVc",
                "JcTNPt1asVc",
                "JcTNPt1Asvc",
                "jCTnpt1aSvC",
                "JCtNpt1ASvC",
                "jCtnPt1AsvC",
                "jCtnPt1ASvc",
                "JCTnPT1ASvC",
                "jCtNPt1AsvC",
                "JCTNPT1ASvC",
                "jCtNPt1ASvc",
                "jCtnPt1aSVC",
                "jCtNPt1aSVC",
                "jCtnPt1ASvC",
                "jCTNPt1asvc",
                "jCTNPt1ASVC",
                "JCtNPt1asVC",
                "jCTnPt1AsVc",
                "JCtNPt1aSVc",
                "JCtNPt1AsvC",
                "JCtNPt1ASvc",
                "jctnpT1asvc",
                "JCTnPt1aSVC",
                "JCTNpt1AsVc",
                "jctNpT1aSvC",
                "jCTNPt1asvC",
                "jCTNPt1aSvc",
                "JCtNPt1aSVC",
                "JCtNPt1ASvC",
                "JCTnPt1aSVc",
                "JCTnPt1asVC",
                "JCTNpt1ASVc",
                "JCTnPt1AsvC",
                "JCTNpt1AsVC",
                "JCtnPt1aSVc",
                "JCtnPt1asVC",
                "jctnpT1AsVC",
                "jcTnpT1aSvC",
                "JCTnPt1ASvc",
                "jctnpT1ASVc",
                "jCTNPt1AsVc",
                "JCTNpt1asvc",
                "jCTnPt1ASVC",
                "jctNpT1asvc",
                "JCTNPt1aSVC",
                "jctnpT1aSvC",
                "JCtnPt1ASvc",
                "JCtnPt1AsvC",
                "JCTNpt1ASVC",
                "jctNpT1ASVC",
                "jCTNpt1AsVc",
                "JCTNPt1ASvC",
                "JCtnPt1asVc",
                "JCTnPt1ASvC",
                "jctnpT1ASVC",
                "jCTNPt1AsVC",
                "jCTNPt1ASVc",
                "JCTNpt1asvC",
                "JCTNpt1aSvc",
                "JCtNPt1asVc",
                "jCTnPt1ASVc",
                "jCTnPt1AsVC",
                "jctNpT1asvC",
                "JCtNPt1Asvc",
                "jctnpT1asvC",
                "jctnpT1aSvc",
                "JCtnPt1Asvc",
                "jCTnPt1asvc",
                "jctNpT1aSvc",
                "jcTNpT1aSvC",
                "JCTNPt1AsvC",
                "JCTNPt1ASvc",
                "jcTnpT1asvc",
                "jcTnpT1ASVC",
                "JCTNpt1aSvC",
                "JctnpT1asVC",
                "JctnpT1aSVc",
                "JCTNPt1asVc",
                "JctnpT1AsvC",
                "JctnpT1ASvc",
                "jCTnPt1asvC",
                "jctnPT1aSVC",
                "jCTnPt1aSvc",
                "jcTNpT1aSvc",
                "jcTNpT1asvC",
                "JCTNPt1Asvc",
                "JCtnPt1aSVC",
                "jcTnpT1asvC",
                "jcTnpT1aSvc",
                "JctNpT1aSVC",
                "JctnpT1aSVC",
                "JCTNPt1asVC",
                "JCTNPt1aSVc",
                "JctnpT1ASvC",
                "JCtnPt1ASvC",
                "JctNpT1ASvC",
                "jctnPT1aSVc",
                "jCTnPt1aSvC",
                "jctnPT1asVC",
                "jcTNpT1asvc",
                "jCTNPt1aSvC",
                "jcTnpT1AsVc",
                "JctNpT1aSVc",
                "JctNpT1asVC",
                "jcTNpT1ASVC",
                "JCTnPt1asVc",
                "JCTnPt1Asvc",
                "JctNpT1AsvC",
                "JctNpT1ASvc",
                "jctnPT1asVc",
                "jcTnpT1AsVC",
                "JctNpT1asVc",
                "jcTnpT1ASVc",
                "JctnpT1asVc",
                "JctnpT1Asvc",
                "jcTNpT1ASVc",
                "jcTNpT1AsVC",
                "JctNpT1Asvc",
                "JcTnpT1AsvC",
                "JcTnpT1ASvc",
                "jctNPT1ASvc",
                "jctNPT1AsvC",
                "jcTnPT1aSVC",
                "jCTNPT1AsVc",
                "jcTnPT1ASvC",
                "JcTnpT1asVc",
                "JctnPT1asvC",
                "JctnPT1aSvc",
                "jctNPT1asVc",
                "JcTNpT1aSVC",
                "jCtNpt1ASVc",
                "jCtNpt1AsVC",
                "JcTnpT1Asvc",
                "jctNPT1Asvc",
                "jctnPT1Asvc",
                "JctNPT1aSvC",
                "JcTnpT1asVC",
                "JcTnpT1aSVc",
                "jCtnpt1AsVc",
                "JctnPT1aSvC",
                "jctNPT1aSVc",
                "jctNPT1asVC",
                "JcTNpT1aSVc",
                "JcTNpT1asVC",
                "jCtNpt1AsVc",
                "jCtnpT1aSVC",
                "jCtnpT1ASvC",
                "jctnPT1AsvC",
                "jctnPT1ASvc",
                "jctNPT1aSVC",
                "JcTNpT1asVc",
                "JCTNpT1AsVc",
                "jCtnpT1aSVc",
                "jCtnpT1asVC",
                "jctNPT1ASvC",
                "jCtnpT1AsvC",
                "jCtnpT1ASvc",
                "jctnPT1ASvC",
                "jCtNpT1aSVC",
                "JctNPT1ASVC",
                "jctnpt1Asvc",
                "jcTNPT1asVc",
                "jctNpt1ASvC",
                "JCtnpT1aSvC",
                "jCtNpT1ASvC",
                "jCtNPT1AsVc",
                "jctNpt1asVC",
                "jctNpt1aSVc",
                "jcTNPT1Asvc",
                "jCTnpT1aSVC",
                "JcTNpT1Asvc",
                "JCtnpT1asvC",
                "jctnpt1asVc",
                "JCtnpT1aSvc",
                "JctnPT1AsVc",
                "jCtNPT1ASVc",
                "jCtNPT1AsVC",
                "jctNpt1asVc",
                "jCTnpT1ASvC",
                "jctnpt1ASvC",
                "jcTnPT1asVc",
                "JctNPT1AsVc",
                "jCTNpT1Asvc",
                "jCTnpT1aSVc",
                "jCTnpT1asVC",
                "jcTNPT1aSVC",
                "JCtNpT1AsVC",
                "JcTNpT1AsvC",
                "jctNpt1Asvc",
                "JCtNpT1ASVc",
                "JcTNpT1ASvc",
                "jCtnPT1AsVc",
                "jcTnPT1Asvc",
                "JCtnpT1asvc",
                "JctNPT1aSvc",
                "jctnpt1aSVc",
                "jctnpt1asVC",
                "JcTnpT1aSVC",
                "JctNPT1asvC",
                "JctnPT1AsVC",
                "JctnPT1ASVc",
                "jCTnpT1AsvC",
                "jcTNPT1ASvC",
                "jCTnpT1ASvc",
                "jctnpt1ASvc",
                "jcTnPT1asVC",
                "JctNPT1ASVc",
                "JctNPT1AsVC",
                "jctnpt1AsvC",
                "JCtnpT1AsVc",
                "JcTnpT1ASvC",
                "jCTnpT1asVc",
                "jcTNPT1aSVc",
                "jcTNPT1asVC",
                "JCtNpT1AsVc",
                "jctNpt1AsvC",
                "jctNpt1ASvc",
                "JcTNpT1ASvC",
                "jcTnPT1aSVc",
                "jcTnPT1AsvC",
                "jcTnPT1ASvc",
                "jctnpt1aSVC",
                "JctNPT1asvc",
                "jCTNpT1asVc",
                "JctnPT1asvc",
                "JctnPT1ASVC",
                "jCTnpT1Asvc",
                "jcTNPT1ASvc",
                "jctNpt1aSVC",
                "jcTNPT1AsvC",
                "jCtnPT1asVC",
                "JCtnpT1Asvc",
                "JctNpt1ASvC",
                "JcTNPT1asVc",
                "jctnPt1AsvC",
                "jctnPt1ASvc",
                "jcTNpt1asvc",
                "JCtNpT1ASvC",
                "jCtnPT1aSVc",
                "jCtnPT1AsvC",
                "jCtnPT1ASvc",
                "JcTNPT1Asvc",
                "jCTNpT1asvc",
                "jcTnpt1AsVc",
                "JctNpt1aSVc",
                "JctNpt1asVC",
                "jctnPt1asVc",
                "jCTnpT1AsVc",
                "JCtNpT1aSVc",
                "JCtNpT1asVC",
                "JcTnpt1aSVC",
                "jcTNpt1ASVC",
                "jCtnPT1asVc",
                "JcTNPT1aSVc",
                "JCtnpT1AsvC",
                "JCtnpT1ASvc",
                "jCTNpT1ASVC",
                "JctNpt1ASvc",
                "JcTNPT1asVC",
                "JctNpt1AsvC",
                "jctnPt1Asvc",
                "jcTNpt1asvC",
                "JCtNpT1AsvC",
                "jctNpt1AsVc",
                "jcTNpt1aSvc",
                "JCtNpT1ASvc",
                "jCtnPT1Asvc",
                "jCtNpT1AsVc",
                "jCTNpT1aSvc",
                "JctnPt1aSvC",
                "JcTNPT1AsvC",
                "JcTNPT1ASvc",
                "jCTNpT1asvC",
                "JctNpt1aSVC",
                "jctnPt1asVC",
                "JCtnPT1aSvC",
                "jctnPt1aSVc",
                "JCtNpT1aSVC",
                "JcTnpt1aSVc",
                "JcTnpt1asVC",
                "jcTnpt1asvc",
                "JCtnpT1ASvC",
                "JctNpt1Asvc",
                "Jctnpt1aSVc",
                "JcTnPT1Asvc",
                "jCtNPT1aSVc",
                "jCtNPT1asVC",
                "jcTnPt1aSVC",
                "Jctnpt1asVC",
                "JcTnpt1AsvC",
                "JcTnpt1ASvc",
                "jCtNpT1AsVC",
                "jCTNpT1aSvC",
                "jcTnpt1ASVC",
                "JctnPt1asvC",
                "jCtNpT1ASVc",
                "JctnPt1aSvc",
                "jCtNPT1AsvC",
                "jCtNPT1ASvc",
                "Jctnpt1AsvC",
                "Jctnpt1ASvc",
                "jcTnPt1ASvC",
                "jcTNpt1AsVc",
                "jCtNpT1asvc",
                "JcTNpt1aSVC",
                "jcTnPt1asVC",
                "jCtNPT1aSVC",
                "jcTnPt1aSVc",
                "Jctnpt1asVc",
                "JcTnpt1ASvC",
                "jCtnPT1aSVC",
                "jCtnPT1ASvC",
                "jcTnpt1ASVc",
                "JctnPt1asvc",
                "jCtNpT1ASVC",
                "jcTnpt1AsVC",
                "JctNpt1asVc",
                "JcTNpt1ASvC",
                "jCtNPT1ASvC",
                "Jctnpt1Asvc",
                "JcTnPT1asVc",
                "jcTnPt1AsvC",
                "jcTnPt1ASvc",
                "jcTNpt1ASVc",
                "jcTNpt1AsVC",
                "jCTnPT1AsvC",
                "jCTnPT1ASvc",
                "JCtNPT1aSvC",
                "jCtnpt1aSVC",
                "jcTnpt1aSvC",
                "JcTNpt1aSVc",
                "JcTNpt1asVC",
                "jCtnpT1ASVc",
                "jCtnpT1AsVC",
                "JcTNpt1AsvC",
                "jcTnPt1asVc",
                "JcTnPT1ASvC",
                "JCtnPT1ASVC",
                "JCTNpT1aSVc",
                "JCTNpT1asVC",
                "jCtnpt1ASvC",
                "jCTnPT1asVc",
                "JcTNpt1ASvc",
                "JcTnPT1aSVc",
                "JcTnPT1asVC",
                "jCTNPT1aSVC",
                "jcTnPt1Asvc",
                "JCTNpT1AsvC",
                "JCTNpT1ASvc",
                "jCTnPT1ASvC",
                "jctNPt1asVc",
                "JCtNPT1aSvc",
                "JCTnpT1asVc",
                "jcTnpt1asvC",
                "jcTnpt1aSvc",
                "JCtNPT1asvC",
                "JcTNpt1asVc",
                "Jctnpt1aSVC",
                "jCtnpT1AsVc",
                "JcTNpt1Asvc",
                "JcTnPT1AsvC",
                "JcTnPT1ASvc",
                "jCTNPT1ASvC",
                "JCTNpT1asVc",
                "JcTnpt1Asvc",
                "jctNPt1Asvc",
                "JCTnpT1Asvc",
                "JcTnPT1aSVC",
                "Jctnpt1ASvC",
                "JCTNpT1Asvc",
                "jctNPt1aSVc",
                "jctNPt1asVC",
                "JCTnpT1asVC",
                "JcTNPT1aSVC",
                "jCtnpt1asVc",
                "JCTnpT1aSVc",
                "JCtNPT1asvc",
                "JCtnPT1AsVc",
                "jctNPT1AsVc",
                "jCTNPT1ASvc",
                "jCtNpt1aSVC",
                "jcTNpt1aSvC",
                "jCTNPT1AsvC",
                "jCTnPT1aSVC",
                "jctNPt1AsvC",
                "JCtNPT1ASVC",
                "JcTNPT1ASvC",
                "jCtnpt1Asvc",
                "jctNPt1ASvc",
                "JCTnpT1AsvC",
                "JCTnpT1ASvc",
                "JCtnPT1asvC",
                "JCtnPT1aSvc",
                "jctnPt1aSVC",
                "jCtNpt1ASvC",
                "jCTNPT1asVc",
                "JcTnpt1asVc",
                "jCTnPT1Asvc",
                "jctNPt1aSVC",
                "jCtnpt1aSVc",
                "jCtnpt1asVC",
                "JCTnpT1aSVC",
                "JCtnPT1AsVC",
                "jctnPt1ASvC",
                "JCtnPT1ASVc",
                "JCTNpT1aSVC",
                "jCtNpt1aSVc",
                "jCtNpt1asVC",
                "jCTNPT1Asvc",
                "jCTnPT1aSVc",
                "jCtnpt1ASvc",
                "jCTnPT1asVC",
                "JCtNPT1ASVc",
                "JCtNPT1AsVC",
                "jCtnpt1AsvC",
                "jctNPt1ASvC",
                "JCTnpT1ASvC",
                "JCtnPT1asvc",
                "jCtNpt1ASvc",
                "jCTNPT1aSVc",
                "jCTNPT1asVC",
                "jCtNpt1AsvC",
                "JCTNpT1ASvC",
                "jCTnpt1ASvC",
                "jCtnPt1aSvC",
                "JcTNPt1asvC",
                "JcTNPt1aSvc",
                "JctNPt1AsVc",
                "JCTNPT1aSvc",
                "jCTnpt1aSVc",
                "jCTnpt1asVC",
                "JCTNPT1asvC",
                "JcTnPt1ASVc",
                "JcTnPt1AsVC",
                "JctNpT1AsVc",
                "JCTnPT1AsVC",
                "JCtnpt1asvc",
                "JCTnPT1ASVc",
                "jCTnpt1ASvc",
                "JcTnPt1asvc",
                "jCTnpt1AsvC",
                "JCTnPT1asvc",
                "JCtnpt1ASVC",
                "JcTNPt1asvc",
                "JcTNPt1ASVC",
                "jCTnpt1aSVC",
                "JCTNPT1asvc",
                "JcTnPt1ASVC",
                "JCtnpt1aSvc",
                "JCtnpt1asvC",
                "JCTnPT1ASVC",
                "jCTNpt1aSVC",
                "JcTnPt1asvC",
                "JctnPt1AsVc",
                "JcTnPt1aSvc",
                "jcTNPt1AsvC",
                "jCTnpt1Asvc",
                "jcTNPt1ASvc",
                "JCtnpt1ASVc",
                "JCtnpt1AsVC",
                "JCTnpt1aSvC",
                "JctNPt1ASVC",
                "jcTNPt1asVc",
                "jCTNpt1asVC",
                "jCTNpt1aSVc",
                "JctnPt1ASVc",
                "JctnPt1AsVC",
                "JcTnPt1aSvC",
                "jcTNPt1Asvc",
                "JCtnpt1AsVc",
                "JCTnpt1aSvc",
                "JcTNPt1aSvC",
                "JCTnpt1asvC",
                "JctNPt1ASVc",
                "JctNPt1AsVC",
                "jcTNPt1aSVc",
                "jcTNPt1asVC",
                "jCTnpt1asVc",
                "JCTnPT1AsVc",
                "JctNPt1asvc",
                "jCTNpt1asVc",
                "jctNpT1Asvc",
                "jCTNpt1Asvc",
                "JctnPt1ASVC",
                "JCTNPT1AsVc",
                "JCtNpt1AsVC",
                "JCTnpt1asvc",
                "jCtNPt1asvc",
                "jcTNPt1aSVC",
                "JCtNpt1ASVc",
                "JctNPt1asvC",
                "jCtnPt1AsVc",
                "JctNPt1aSvc",
                "JCTnpt1ASVC",
                "jCTNpt1AsvC",
                "jCTNpt1ASvc",
                "JCTNPT1ASVc",
                "JCTNPT1AsVC",
                "jcTNPt1ASvC",
                "JCtNpt1asvc",
                "jctNpT1asVc",
                "JCtNpt1ASVC",
                "jCtnPt1ASVc",
                "jCtnPt1AsVC",
                "JctNPt1aSvC",
                "JCTnpt1ASVc",
                "JCTnpt1AsVC",
                "jCTNpt1ASvC",
                "jCtNPt1AsVC",
                "JCTNPT1ASVC",
                "jCtNPt1ASVc",
                "JCtNpt1asvC",
                "JCtNpt1aSvc",
                "jCtnPt1asvc",
                "JCTnPT1asvC",
                "JCTnPT1aSvc",
                "JcTNPt1ASVc",
                "JcTNPt1AsVC",
                "jCtNPt1aSvC",
                "JCtnpt1aSvC",
                "jCtnPt1ASVC",
                "JCTnpt1AsVc",
                "jCtNPt1ASVC",
                "JCtNpt1aSvC",
                "jCtnPt1asvC",
                "JCTnPT1aSvC",
                "jCtnPt1aSvc",
                "JcTNPt1AsVc",
                "jCtNPt1asvC",
                "jCtNPt1aSvc",
                "JCTNPT1aSvC",
                "JcTnPt1AsVc",
                "jCTNPt1aSVc",
                "jCTNPt1asVC",
                "jctnpT1ASvC",
                "jCTNPt1AsvC",
                "jCTNPt1ASvc",
                "JCtNPt1asvc",
                "JCtNPt1ASVC",
                "jctnpT1aSVc",
                "jctnpT1asVC",
                "JCtnPt1AsVc",
                "JCTnPt1asvC",
                "JCTnPt1aSvc",
                "jCtNPt1AsVc",
                "jCTNPt1aSVC",
                "jCTNPt1ASvC",
                "JCTNpt1asVc",
                "JCtNPt1asvC",
                "JCtNPt1aSvc",
                "jctnpT1asVc",
                "JCTnPt1asvc",
                "JCTNpt1Asvc",
                "jctNpT1ASvC",
                "JCtnPt1asvc",
                "jctnpT1Asvc",
                "JCTnPt1ASVC",
                "JCTNpt1aSVc",
                "JCTNpt1asVC",
                "jCTnPt1AsvC",
                "jCTnPt1ASvc",
                "JctnpT1aSvC",
                "JCTNPt1asvC",
                "jctNpT1asVC",
                "JCtNPt1AsVc",
                "JCTNPt1aSvc",
                "JCtnPt1ASVC",
                "JCTNpt1ASvc",
                "JCTNpt1AsvC",
                "jCTnPt1asVc",
                "jctNpT1aSVc",
                "jctNpT1AsvC",
                "jctNpT1ASvc",
                "jCTNPt1asVc",
                "jctnpT1AsvC",
                "jctnpT1ASvc",
                "jCTNPt1Asvc",
                "JCtNpt1AsVc",
                "JCTNpt1aSVC",
                "jCTnPt1Asvc",
                "JCtNPt1ASVc",
                "JCtNPt1AsVC",
                "JCTNPt1aSvC",
                "jctnpT1aSVC",
                "JCtnPt1ASVc",
                "JCtnPt1AsVC",
                "JCTnPt1aSvC",
                "JCTNpt1ASvC",
                "jCTnPt1asVC",
                "jctnPT1aSvC",
                "jCTnPt1aSVc",
                "jctNpT1aSVC",
                "JCTNPt1ASVC",
                "JCtnPt1aSvC",
                "jcTnpT1aSVc",
                "jcTnpT1asVC",
                "jcTnpT1AsvC",
                "JctNpT1aSvC",
                "jcTnpT1ASvc",
                "JctnpT1asvc",
                "JctnpT1ASVC",
                "jctnPT1aSvc",
                "jCTnPt1aSVC",
                "jctnPT1asvC",
                "jcTNpT1aSVC",
                "JCTNPt1ASVc",
                "JCTNPt1AsVC",
                "JCtnPt1asvC",
                "JCtnPt1aSvc",
                "jcTnpT1aSVC",
                "JCTnPt1ASVc",
                "JctNpT1asvC",
                "JctNpT1aSvc",
                "jcTnpT1ASvC",
                "JctnpT1asvC",
                "jCTnPt1ASvC",
                "JctnpT1aSvc",
                "JCTNPt1asvc",
                "jcTNpT1ASvC",
                "jctnPT1asvc",
                "jcTNpT1aSVc",
                "jcTNpT1asVC",
                "JCTNPt1AsVc",
                "JctNpT1asvc",
                "JCtNPt1aSvC",
                "JctnpT1AsVc",
                "jcTNpT1AsvC",
                "jcTNpT1ASvc",
                "JCTnPt1AsVC",
                "JctNpT1ASVC",
                "jcTNpT1asVc",
                "jcTnpT1asVc",
                "jcTnpT1Asvc",
                "JctnpT1ASVc",
                "JctnpT1AsVC",
                "jcTNpT1Asvc",
                "JCTnPt1AsVc",
                "JctNpT1AsVC",
                "JctNpT1ASVc",
                "jcTnPT1asvC",
                "JcTnpT1ASVC",
                "jctNPT1ASVC",
                "jCtNpt1asVc",
                "jctnPT1AsVc",
                "jcTnPT1aSvc",
                "jctnpt1aSvC",
                "JCtNPT1AsVc",
                "JctnPT1aSVC",
                "JctnPT1ASvC",
                "JcTNpT1asvC",
                "JcTNpT1aSvc",
                "jCtNpt1Asvc",
                "JcTnpT1ASVc",
                "JcTnpT1AsVC",
                "jCtnpT1aSvC",
                "jctNPT1ASVc",
                "jctNPT1AsVC",
                "jcTNPT1aSvC",
                "jctnPT1ASVc",
                "jctnPT1AsVC",
                "jcTnPT1aSvC",
                "JcTnpT1asvc",
                "jctNPT1asvc",
                "JcTNpT1asvc",
                "JcTnpT1AsVc",
                "jCtnpT1asvC",
                "jCtnpT1aSvc",
                "jctnPT1ASVC",
                "jctNPT1asvC",
                "jctNPT1aSvc",
                "jCtnpT1asvc",
                "jCtnpT1ASVC",
                "jctNPT1aSvC",
                "jCtNpT1asvC",
                "jCtNpT1aSvc",
                "jctnpt1ASVc",
                "JctNPT1AsvC",
                "JctNPT1ASvc",
                "jctnpt1AsVC",
                "jCTnpT1aSvC",
                "JcTNpT1AsVc",
                "JctNPT1asVc",
                "jctNpt1asvc",
                "jcTNPT1ASVc",
                "jcTNPT1AsVC",
                "jCtNpT1aSvC",
                "JctNPT1ASvC",
                "jctnpt1AsVc",
                "jCTnpT1asvC",
                "jCTnpT1aSvc",
                "jCtNPT1asVc",
                "JcTNpT1AsVC",
                "JcTNpT1ASVc",
                "jcTnPT1AsVc",
                "JCtnpT1aSVC",
                "jCtNPT1Asvc",
                "jcTNPT1AsVc",
                "jCTNpT1ASVc",
                "jCTNpT1AsVC",
                "jCTnpT1asvc",
                "jcTNPT1asvC",
                "jcTNPT1aSvc",
                "JCtNpT1Asvc",
                "jctNpt1ASVc",
                "jctNpt1AsVC",
                "JcTNpT1ASVC",
                "jcTnPT1ASVc",
                "jcTnPT1AsVC",
                "JCtnpT1asVC",
                "JctNPT1aSVC",
                "JcTnpT1asvC",
                "jctnpt1asvc",
                "JCtnpT1aSVc",
                "JcTnpT1aSvc",
                "JctnPT1asVc",
                "JctnPT1Asvc",
                "jCTnpT1ASVC",
                "jctNpt1aSvC",
                "jctnpt1ASVC",
                "jcTnPT1asvc",
                "JctNPT1Asvc",
                "jCTNpT1AsVc",
                "jcTNPT1asvc",
                "jctNpt1ASVC",
                "jcTnPT1ASVC",
                "JCtnpT1asVc",
                "JctNPT1aSVc",
                "jctnpt1asvC",
                "jctnpt1aSvc",
                "JcTnpT1aSvC",
                "JctNPT1asVC",
                "JctnPT1aSVc",
                "JctnPT1asVC",
                "JctnPT1AsvC",
                "JctnPT1ASvc",
                "jCTnpT1AsVC",
                "jctNpt1asvC",
                "jcTNPT1ASVC",
                "JCtNpT1asVc",
                "JcTNpT1aSvC",
                "jCTnpT1ASVc",
                "jctNpt1aSvc"), service.letterCasePermutation("JcTNPT1AsvC")));
    }
}