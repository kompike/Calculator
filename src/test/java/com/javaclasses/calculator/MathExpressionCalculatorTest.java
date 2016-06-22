package com.javaclasses.calculator;

import org.junit.Assert;
import org.junit.Test;

public class MathExpressionCalculatorTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testIntegerNumberEvaluation() {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("28"), 0.0001d);
    }
}
