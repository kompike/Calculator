package com.javaclasses.calculator.context;

/**
 * Basic interface for operating finite-state machine's
 * output data
 */
public interface OutputContext {

    /**
     * Pop the last element from stack of operands
     * @return Result of expression
     */
    double popResult();

    /**
     * Add new operand to output context
     * @param operand Added operand
     */
    void addOperand(Double operand);
}
