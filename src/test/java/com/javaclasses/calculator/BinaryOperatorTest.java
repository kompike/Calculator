package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BinaryOperatorTest {

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();

    private final double delta = 0.0001d;

    @Test
    public void testPlusOperatorEvaluation() throws IncorrectExpressionException {
        assertEquals("Plus operator evaluation does not work properly.",
                28d, calculator.evaluate("10+18"), delta );
    }

    @Test
    public void testMinusOperatorEvaluation() throws IncorrectExpressionException {
        assertEquals("Minus operator evaluation does not work properly.",
                28d, calculator.evaluate("42-14"), delta );
    }

    @Test
    public void testMultiplyOperatorEvaluation() throws IncorrectExpressionException {
        assertEquals("Multiply operator evaluation does not work properly.",
                28d, calculator.evaluate("7*4"), delta );
    }

    @Test
    public void testDivideOperatorEvaluation() throws IncorrectExpressionException {
        assertEquals("Divide operator evaluation does not work properly.",
                28.5d, calculator.evaluate("57/2"), delta );
    }

    @Test
    public void testPowerOperatorEvaluation() throws IncorrectExpressionException {
        assertEquals("Power operator evaluation does not work properly.",
                64d, calculator.evaluate("4^3"), delta );
    }

    @Test
    public void testOperatorPriorityEvaluation() throws IncorrectExpressionException {
        assertEquals("Priority evaluation does not work properly.",
                18d, calculator.evaluate("2+2^3*2"), delta);
    }

    @Test
    public void testSingleBracketsEvaluation() throws IncorrectExpressionException {
        assertEquals("Single brackets do not work properly.",
                8d, calculator.evaluate("2*(3+1)"), delta );
    }

    @Test
    public void testNestedBracketsEvaluation() throws IncorrectExpressionException {
        assertEquals("Nested brackets do not work properly.",
                3d, calculator.evaluate("((4/(5-3)-1)+2)"), delta );
    }

    @Test
    public void testExpressionWithSpacesEvaluation() throws IncorrectExpressionException {
        assertEquals("Whitespaces are not skipped.",
                22d, calculator.evaluate("2 * 3 +  2 ^4"), delta );
    }

    @Test
    public void testExpressionWithIncorrectOperatorsNumber() throws Exception {

        try {
            calculator.evaluate("2+3-");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong error position returned.", 4, e.getPosition());
        }
    }

    @Test
    public void testDivisionByZeroEvaluation() throws Exception {

        try {
            calculator.evaluate("2/(2-2)");
            fail("ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero message was not returned.",
                    "Division by zero is prohibited.", e.getMessage());
        }
    }

    @Test
    public void testEmptyBracketsEvaluation() throws Exception {

        try {
            calculator.evaluate("()");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Found empty bracket position does not equal expected.", 2, e.getPosition());
        }
    }

    @Test
    public void testIncorrectOpeningBracketsNumber() throws Exception {

        try {
            calculator.evaluate("((2+(3-(2*1))+1)");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong missing closing bracket position.",
                    "Closing bracket missing at position: 16", e.getMessage());
        }
    }

    @Test
    public void testIncorrectClosingBracketsNumber() throws Exception {

        try {
            calculator.evaluate("2+(3-(2*1))+1)");
            fail("IncorrectExpressionException was not thrown");
        } catch (IncorrectExpressionException e) {
            assertEquals("Wrong position of redundant closing bracket.", 14,  e.getPosition());
        }
    }
}
