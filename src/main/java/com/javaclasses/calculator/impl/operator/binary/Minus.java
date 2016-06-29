package com.javaclasses.calculator.impl.operator.binary;

import com.javaclasses.calculator.impl.BinaryOperator;

/**
 * Binary operator implementation for minus operation
 */
public class Minus extends BinaryOperator {

    public Minus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}
