package com.algorithm.string;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluateTheBracketPairsOfAStringTest {

    @Test
    public void evaluate() {
        EvaluateTheBracketPairsOfAString service = new EvaluateTheBracketPairsOfAString();
        assertEquals("bobistwoyearsold", service.evaluate("(name)is(age)yearsold", CollectionUtils.matrixArr2List(new String[][]{{"name", "bob"}, {"age", "two"}})));
        assertEquals("hi?", service.evaluate("hi(name)", CollectionUtils.matrixArr2List(new String[][]{{"a", "b"}})));
        assertEquals("yesyesyesaaa", service.evaluate("(a)(a)(a)aaa", CollectionUtils.matrixArr2List(new String[][]{{"a", "yes"}})));
    }
}