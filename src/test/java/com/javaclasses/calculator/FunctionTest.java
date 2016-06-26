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

    @Test
    public void testMinFunction() throws EvaluationException {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("min(100,28,31)"), 0.0001d );
    }

    @Test
    public void testMaxFunction() throws EvaluationException {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                65d, calculator.evaluate("max(65,28,3,17)"), 0.0001d );
    }

    @Test
    public void testPiFunction() throws EvaluationException {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                Math.PI, calculator.evaluate("pi()"), 0.0001d );
    }
}
