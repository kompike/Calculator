package com.javaclasses.calculator.operator;

/**
 * Binary operator implementation for power operation
 */
public class Power extends BinaryOperator {

    public Power() {
        this(Priority.HIGH);
    }

    public Power(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
