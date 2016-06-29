package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UnaryOperatorTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    final double delta = 0.0001d;

    @Test
    public void testFactorialEvaluation() throws IncorrectExpressionException {

        assertEquals("Evaluated result does not equal expected number.",
                120d, calculator.evaluate("5!"), delta);
    }

    @Test
    public void testUnaryMinusInFunctionEvaluation() throws IncorrectExpressionException {

        assertEquals("Evaluated result does not equal expected number.",
                2d, calculator.evaluate("-min(-1,-2,4,3!)"), delta );
    }

    @Test
    public void testUnaryMinusEvaluation() throws IncorrectExpressionException {

        assertEquals("Evaluated result does not equal expected number.",
                16d, calculator.evaluate("-4^2"), delta );
    }

    @Test
    public void testUnaryMinusWithBracketsEvaluation() throws IncorrectExpressionException {

        assertEquals("Evaluated result does not equal expected number.",
                -16d, calculator.evaluate("-(4^2)"), delta );
    }

    @Test
    public void testIncorrectFactorialPositionEvaluation() throws IncorrectExpressionException {

        try {
            calculator.evaluate("!4");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong position of inappropriate unary operator returned.", 1, e.getPosition());
        }
    }

}
