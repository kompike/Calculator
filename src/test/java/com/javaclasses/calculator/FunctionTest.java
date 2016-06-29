package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FunctionTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    private final double delta = 0.0001d;

    @Test
    public void testSumFunctionEvaluation() throws IncorrectExpressionException {

        assertEquals("Sum function does not work properly.",
                28d, calculator.evaluate("sum(10,18)"), delta);
    }

    @Test
    public void testMinFunctionEvaluation() throws IncorrectExpressionException {

        assertEquals("Minimum function does not work properly.",
                28d, calculator.evaluate("min(100,28,31)"), delta );
    }

    @Test
    public void testMaxFunctionEvaluation() throws IncorrectExpressionException {

        assertEquals("Maximum function does not work properly.",
                65d, calculator.evaluate("max(65,28,3,17)"), delta );
    }

    @Test
    public void testPiFunctionEvaluation() throws IncorrectExpressionException {

        assertEquals("Pi function does not work properly.",
                Math.PI, calculator.evaluate("pi()"), delta );
    }@Test
    public void testArgumentSeparatorOutsideFunction() throws Exception {

        try {
            calculator.evaluate("2,3");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Caught exception message does not equals expected.",
                    "It is not allowed to use comma beyond function: 2", e.getMessage());
        }
    }

    @Test
    public void testArgumentSeparatorInBrackets() throws Exception {

        try {
            calculator.evaluate("(2,3)");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong position of redundant argument separator returned.",
                    3, e.getPosition());
        }
    }

    @Test
    public void testIncorrectArgumentsNumberInSumFunction() throws IncorrectExpressionException {

        try {
            calculator.evaluate("sum(10)");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong position returned for incorrect arguments number in sum function.",
                    "Arguments number must be from 2 to 2147483647 for the function at position: 7",
                    e.getMessage());
        }
    }

    @Test
    public void testIncorrectArgumentsNumberInPiFunction() throws IncorrectExpressionException {

        try {
            calculator.evaluate("pi(10)");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong position returned for incorrect pi function.",
                    "Arguments number must be exactly 0 for the function at position: 6",
                    e.getMessage());
        }
    }
}
