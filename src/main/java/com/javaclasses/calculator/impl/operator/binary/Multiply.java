package com.javaclasses.calculator.impl.operator.binary;

import com.javaclasses.calculator.impl.BinaryOperator;

/**
 * Binary operator implementation for multiply operation
 */
public class Multiply extends BinaryOperator {

    public Multiply(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
