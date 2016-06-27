package com.javaclasses.calculator.impl;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.operator.binary.Priority;

/**
 * Binary operator abstract instance with priority comparison
 */
public abstract class BinaryOperator implements Comparable<BinaryOperator>{

    private Priority priority;

    public BinaryOperator(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(BinaryOperator operator) {

        return this.priority.compareTo(operator.priority);
    }

    /**
     * Evaluates the result depending on current binary
     * operator implementation
     * @param leftOperand First operand of current binary operator
     * @param rightOperand Second operand of current binary operator
     * @return Result of operator execution
     */
    public abstract double execute(double leftOperand, double rightOperand) throws IncorrectExpressionException;
}
