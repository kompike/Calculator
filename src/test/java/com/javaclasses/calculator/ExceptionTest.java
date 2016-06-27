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

    @Test
    public void testIncorrectExpressionEvaluation() throws Exception {

        try {
            calculator.evaluate("2+3-");
            Assert.fail("EvaluationException was not thrown");
        } catch (EvaluationException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Can not execute expression after position 4", e.getMessage());
        }
    }

    @Test
    public void testDivisionByZeroEvaluation() throws Exception {

        try {
            calculator.evaluate("2/(2-2)");
            Assert.fail("ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            Assert.assertEquals("Caught exception message does not equals expected.",
                    "Division by zero is prohibited", e.getMessage());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyBracketsEvaluation() throws Exception {

        calculator.evaluate("()");
    }

    @Test(expected = IllegalStateException.class)
    public void testIncorrectBracketsNumberEvaluation() throws Exception {

        calculator.evaluate("2+(3-(2*1))+1)");
    }

    @Test(expected = IllegalStateException.class)
    public void testIncorrectSumFunction() throws EvaluationException {

        calculator.evaluate("sum(10)");
    }

    @Test(expected = IllegalStateException.class)
    public void testIncorrectPiFunction() throws EvaluationException {

        calculator.evaluate("pi(10)");
    }
}
