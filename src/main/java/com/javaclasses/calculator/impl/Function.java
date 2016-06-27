package com.javaclasses.calculator.impl;

import com.javaclasses.calculator.IncorrectExpressionException;

/**
 * Abstract instance for math functions
 */
public interface Function {

    /**
     * Executes current function logic
     * @param args Possible function arguments
     * @return Result of current math function
     */
    double execute(Double... args) throws IncorrectExpressionException;
}
