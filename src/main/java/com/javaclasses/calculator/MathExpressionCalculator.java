package com.javaclasses.calculator;

import com.javaclasses.calculator.exception.EvaluationException;

/**
 * Basic interface for math expressions calculation
 */

public interface MathExpressionCalculator {

    /**
     * Method evaluates given string as math expression
     * @param expression String representation of math expression
     * @return result of given expression
     */

    double evaluate(String expression) throws EvaluationException;
}
