package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class FunctionTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testSumFunction() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equal expected number.",
                28d, calculator.evaluate("sum(10,18)"), 0.0001d );
    }

    @Test
    public void testMinFunction() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equal expected number.",
                28d, calculator.evaluate("min(100,28,31)"), 0.0001d );
    }

    @Test
    public void testMaxFunction() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equal expected number.",
                65d, calculator.evaluate("max(65,28,3,17)"), 0.0001d );
    }

    @Test
    public void testPiFunction() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equal expected number.",
                Math.PI, calculator.evaluate("pi()"), 0.0001d );
    }
}
