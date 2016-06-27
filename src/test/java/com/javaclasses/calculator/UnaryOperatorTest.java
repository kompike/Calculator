package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class UnaryOperatorTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testFactorial() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equal expected number.",
                120d, calculator.evaluate("5!"), 0.0001d );
    }

    @Test
    public void testUnaryMinusInFunction() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equal expected number.",
                2d, calculator.evaluate("-min(-1,-2,4,3!)"), 0.0001d );
    }

    @Test
    public void testUnaryMinus() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equal expected number.",
                16d, calculator.evaluate("-4^2"), 0.0001d );
    }

    @Test
    public void testUnaryMinusWithBrackets() throws IncorrectExpressionException {

        Assert.assertEquals("Evaluated result does not equal expected number.",
                -16d, calculator.evaluate("-(4^2)"), 0.0001d );
    }

}
