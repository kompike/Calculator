package com.javaclasses.calculator.impl;

import com.javaclasses.calculator.IncorrectExpressionException;

/**
 * Abstract instance for math functions
 */
public interface Function {

    /**
     * Return minimum number of possible function arguments
     * @return Minimum number of possible function arguments
     */

    int getMinimumArgumentsNumber();

    /**
     * Return maximum number of possible function arguments
     * @return Maximum number of possible function arguments
     */
    int getMaximumArgumentsNumber();

    /**
     * Executes current function logic
     * @param args Possible function arguments
     * @return Result of current math function
     */
    double execute(Double... args) throws IncorrectExpressionException;
}
