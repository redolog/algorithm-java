package com.algorithm.string.subString;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SentenceSimilarityIIITest {

    @Test
    public void areSentencesSimilar() {
        SentenceSimilarityIII service = new SentenceSimilarityIII();
        assertTrue(service.areSentencesSimilar("My name is Haley", "My Haley"));
        assertTrue(service.areSentencesSimilar("Eating right now", "Eating"));
        assertTrue(service.areSentencesSimilar("xD iP tqchblXgqvNVdi", "FmtdCzv Gp YZf UYJ xD iP tqchblXgqvNVdi"));
        assertFalse(service.areSentencesSimilar("of", "A lot of words"));
        assertFalse(service.areSentencesSimilar("Luky", "Lucccky"));
        assertFalse(service.areSentencesSimilar("a BaabbAABbBbbaAb", "a BbbA baaaaBaAabB bbab AaAB"));
    }
}