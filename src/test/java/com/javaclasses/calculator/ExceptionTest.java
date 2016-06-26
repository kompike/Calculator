package com.javaclasses.calculator;

import com.javaclasses.calculator.exception.EvaluationException;
import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testEmptyExpressionEvaluation() throws Exception {

        try {
            calculator.evaluate("");
            Assert.fail("EvaluationException was not thrown");
        } catch (EvaluationException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Can not execute expression after position 0", e.getMessage());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyBracketsEvaluation() throws Exception {
        calculator.evaluate("()");
    }
}
