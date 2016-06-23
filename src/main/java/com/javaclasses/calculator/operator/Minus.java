package com.javaclasses.calculator.operator;

/**
 * Binary operator implementation for minus operation
 */
public class Minus extends BinaryOperator {

    public Minus() {
        this(Priority.LOW);
    }

    public Minus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}
