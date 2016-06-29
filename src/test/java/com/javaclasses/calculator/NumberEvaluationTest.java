package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class NumberEvaluationTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testIntegerNumberEvaluation() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("28"), 0.0001d);
    }

    @Test
    public void testDecimalNumberEvaluation() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                28.25d, calculator.evaluate("28.25"), 0.0001d);
    }

    @Test
    public void testIncorrectDecimalNumberEvaluation() throws IncorrectExpressionException {

        try {
            calculator.evaluate("28.");
            Assert.fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Inappropriate element at position: 0", e.getMessage());
        }
    }
}
