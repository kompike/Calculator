package com.javaclasses.calculator.impl.operator.binary;

import com.javaclasses.calculator.impl.BinaryOperator;

/**
 * Binary operator implementation for power operation
 */
public class Power extends BinaryOperator {

    public Power(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
