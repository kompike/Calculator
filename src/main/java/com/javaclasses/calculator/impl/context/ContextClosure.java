package com.javaclasses.calculator.impl.context;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Function;

/**
 * Handles function executing information
 */
public interface ContextClosure {

    /**
     * Checks if current closure is function closure
     */
    boolean isInFunction();

    /**
     * Returns current closure function
     */
    Function getFunction();

    /**
     * Executes current function or expression in brackets
     */
    void closeContext(OutputContext outputContext) throws IncorrectExpressionException;
}
