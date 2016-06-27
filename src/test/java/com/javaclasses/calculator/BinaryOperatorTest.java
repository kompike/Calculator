package com.javaclasses.calculator;

import com.javaclasses.calculator.exception.EvaluationException;
import org.junit.Assert;
import org.junit.Test;

public class BinaryOperatorTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    @Test
    public void testPlusOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("10+18"), 0.0001d );
    }

    @Test
    public void testMinusOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("42-14"), 0.0001d );
    }

    @Test
    public void testMultiplyOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                28d, calculator.evaluate("7*4"), 0.0001d );
    }

    @Test
    public void testDivideOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                28.5d, calculator.evaluate("57/2"), 0.0001d );
    }

    @Test
    public void testPowerOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                64d, calculator.evaluate("4^3"), 0.0001d );
    }

    @Test
    public void testOperatorPriority() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                18d, calculator.evaluate("2+2^3*2"), 0.0001d );
    }

    @Test
    public void testSingleBrackets() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                8d, calculator.evaluate("2*(3+1)"), 0.0001d );
    }

    @Test
    public void testNestedBrackets() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                33d, calculator.evaluate("2^(3*(4/(5-3)-1)+2)+1"), 0.0001d );
    }

    @Test
    public void testExpressionWithSpaces() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                22d, calculator.evaluate("2 * 3 +  2 ^4"), 0.0001d );
    }

    @Test
    public void testUnaryOperator() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                -2d, calculator.evaluate("-5+3"), 0.0001d );
    }

    @Test
    public void testUnaryOperatorInFunction() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                7d, calculator.evaluate("-min(1,3,-7,5)"), 0.0001d );
    }

    @Test
    public void testUnaryOperatorWithBrackets() throws EvaluationException {
        Assert.assertEquals("Evaluated result does not equals expected number.",
                -8d, calculator.evaluate("-(5+3)"), 0.0001d );
    }
}
