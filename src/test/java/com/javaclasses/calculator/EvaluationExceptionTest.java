package com.javaclasses.calculator;

import com.javaclasses.calculator.exception.EvaluationException;
import org.junit.Assert;
import org.junit.Test;

public class EvaluationExceptionTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testEmptyExpressionEvaluation() throws Exception {

        try {
            calculator.evaluate("");
            Assert.fail("");
        } catch (EvaluationException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Can not execute expression after position 0", e.getMessage());
        }
    }
}
