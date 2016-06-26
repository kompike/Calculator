package com.javaclasses.calculator;

import com.javaclasses.calculator.exception.EvaluationException;
import org.junit.Assert;
import org.junit.Test;

public class FunctionTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testSumFunction() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("sum(10,18)"), 0.0001d );
    }
}
