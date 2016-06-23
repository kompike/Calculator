package com.javaclasses.calculator;

import com.javaclasses.calculator.exception.EvaluationException;
import org.junit.Assert;
import org.junit.Test;

public class BinaryOperatorTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testPlusOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("10+18"), 0.0001d );
    }

    @Test
    public void testMinusOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("42-14"), 0.0001d );
    }

    @Test
    public void testMultiplyOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("7*4"), 0.0001d );
    }
}
