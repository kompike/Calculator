package com.javaclasses.calculator;

import com.javaclasses.calculator.exception.EvaluationException;
import org.junit.Assert;
import org.junit.Test;

public class NumberEvaluationTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testIntegerNumberEvaluation() throws EvaluationException {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("28"), 0.0001d);
    }
}
