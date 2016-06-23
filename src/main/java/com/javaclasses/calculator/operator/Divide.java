package com.javaclasses.calculator.operator;

/**
 * Binary operator implementation for divide operation
 */
public class Divide extends BinaryOperator {

    public Divide() {
        this(Priority.MEDIUM);
    }

    public Divide(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
