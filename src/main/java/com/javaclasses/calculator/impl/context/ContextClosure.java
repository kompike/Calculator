package com.javaclasses.calculator.impl.context;

import com.javaclasses.calculator.IncorrectExpressionException;

/**
 * Handles function executing information
 */
public interface ContextClosure {

    /**
     * Checks if current closure is function closure
     */
    boolean isInFunction();

    /**
     * Executes current function or expression in brackets
     */
    void closeContext(OutputContext outputContext) throws IncorrectExpressionException;
}
