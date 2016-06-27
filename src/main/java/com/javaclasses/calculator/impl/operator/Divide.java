package com.javaclasses.calculator.impl.operator;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.BinaryOperator;

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
    public double execute(double leftOperand, double rightOperand)
            throws IncorrectExpressionException {

        if (rightOperand == 0.0) {

            throw new IncorrectExpressionException("Division by zero is prohibited");
        }

        return leftOperand / rightOperand;
    }
}
