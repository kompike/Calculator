package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IncorrectExpressionTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testEmptyExpressionEvaluation() throws Exception {

        try {
            calculator.evaluate("");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong error message returned for empty brackets.",
                    "Inappropriate element at position: 0", e.getMessage());
        }

    }

    @Test
    public void testInvalidSymbolEvaluation() throws Exception {

        try {
            calculator.evaluate("2+4-t");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong error message returned for empty brackets.",
                    "Inappropriate element at position: 4", e.getMessage());
        }
    }


}
