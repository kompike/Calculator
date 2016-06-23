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

    @Test
    public void testDecimalNumberEvaluation() throws EvaluationException {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                28.25d, calculator.evaluate("28.25"), 0.0001d);
    }

    @Test
    public void testIncorrectDecimalNumberEvaluation() throws EvaluationException {

        try {
            calculator.evaluate("28.");
            Assert.fail("EvaluationException was not thrown");
        } catch (EvaluationException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Can not execute expression after position 0", e.getMessage());
        }
    }
}
