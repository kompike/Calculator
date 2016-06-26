package com.javaclasses.calculator.function;

/**
 * Abstract instance for math functions
 */
public interface Function {

    /**
     * Executes current function logic
     * @param args Possible function arguments
     * @return Result of current math function
     */
    double execute(Double... args);
}
