package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoalParserInterpretationTest {

    @Test
    public void interpret() {
        GoalParserInterpretation service = new GoalParserInterpretation();
        assertEquals("Goal", service.interpret("G()(al)"));
        assertEquals("Gooooal", service.interpret("G()()()()(al)"));
        assertEquals("alGalooG", service.interpret("(al)G(al)()()G"));
    }
}