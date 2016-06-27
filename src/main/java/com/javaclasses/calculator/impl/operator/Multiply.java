package com.javaclasses.calculator.impl.operator;

import com.javaclasses.calculator.impl.BinaryOperator;

/**
 * Binary operator implementation for multiply operation
 */
public class Multiply extends BinaryOperator {

    public Multiply() {
        this(Priority.MEDIUM);
    }

    public Multiply(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
