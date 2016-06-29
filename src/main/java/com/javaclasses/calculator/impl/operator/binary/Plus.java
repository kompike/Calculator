package com.javaclasses.calculator.impl.operator.binary;

import com.javaclasses.calculator.impl.BinaryOperator;

/**
 * Binary operator implementation for plus operation
 */
public class Plus extends BinaryOperator {

    public Plus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
