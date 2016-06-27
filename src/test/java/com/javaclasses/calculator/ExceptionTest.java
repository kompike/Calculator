package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class ExceptionTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testEmptyExpressionEvaluation() throws Exception {

        try {
            calculator.evaluate("");
            Assert.fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Expression contains incorrect symbol after position: 0", e.getMessage());
        }

    }

    @Test
    public void testIncorrectExpressionEvaluation() throws Exception {

        try {
            calculator.evaluate("2+3-");
            Assert.fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Expression contains incorrect symbol after position: 4", e.getMessage());
        }
    }

    @Test
    public void testDivisionByZeroEvaluation() throws Exception {

        try {
            calculator.evaluate("2/(2-2)");
            Assert.fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Division by zero is prohibited", e.getMessage());
        }
    }

    @Test
    public void testArgumentSeparatorOutsideFunctionEvaluation() throws Exception {

        try {
            calculator.evaluate("2,3");
            Assert.fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "It is not allowed to use comma beyond function: 2", e.getMessage());
        }
    }

    @Test(expected = IncorrectExpressionException.class)
    public void testEmptyBracketsEvaluation() throws Exception {

        calculator.evaluate("()");
    }

    @Test(expected = IncorrectExpressionException.class)
    public void testIncorrectBracketsNumberEvaluation() throws Exception {

        calculator.evaluate("2+(3-(2*1))+1)");
    }

    @Test(expected = IncorrectExpressionException.class)
    public void testIncorrectSumFunction() throws IncorrectExpressionException {

        calculator.evaluate("sum(10)");
    }

    @Test(expected = IncorrectExpressionException.class)
    public void testIncorrectPiFunction() throws IncorrectExpressionException {

        calculator.evaluate("pi(10)");
    }
}
