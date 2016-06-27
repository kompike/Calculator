package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Functional test for all groups of tokens
 */
public class MathExpressionCalculatorTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testMathExpressionEvaluation() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equals expected number.",
                2d, calculator.evaluate("2*(sum(1,2,max(1,2,3)) - min(sum(4,min(5,6),7),2+8,2^2) + 1) / 3"), 0.0001d );

    }

}
