package com.javaclasses.calculator.impl;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.context.OutputContext;

/**
 * Abstract entity of input sequence's single token
 */
public interface EvaluationCommand {

    /**
     * Evaluates single token from input context
     * @param outputContext
     */
    void execute(OutputContext outputContext) throws IncorrectExpressionException;
}
