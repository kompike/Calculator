package com.javaclasses.calculator.impl.context;

/**
 * Basic interface for operating finite-state machine's
 * input data
 */
public interface InputContext {

    /**
     * Returns current position in input context sequence
     * @return current position
     */
    int getCurrentPosition();

    /**
     * Increment current position with given value
     * @param value Value to increment current position with
     */
    void incrementPosition(int value);

    /**
     * Represents remaining input context sequence
     * @return Remaining expression
     */
    String getRemainingExpression();

    /**
     * Check if there is input data to parse
     * @return false if input data is finished
     */
    boolean hasMoreToParse();
}
