package com.javaclasses.calculator.context;

import com.javaclasses.calculator.operator.BinaryOperator;

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
     * Adds new operand to output context
     * @param operand Added operand
     */
    void addOperand(Double operand);

    /**
     * Adds new operator to output context
     * @param operator Added operator
     */
    void addOperator(BinaryOperator operator);
}
