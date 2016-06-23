package com.javaclasses.calculator.context;

/**
 * Abstract entity of input sequence's single token
 */
public interface EvaluationContext {

    /**
     * Evaluates single token from input context
     */
    void execute();
}
