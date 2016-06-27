package com.javaclasses.calculator.impl.operator.unary;

import com.javaclasses.calculator.impl.UnaryOperator;

/**
 * Implementation of unary minus operator
 */
public class UnaryMinusOperator extends UnaryOperator {

    public UnaryMinusOperator(Notation notation) {
        super(notation);
    }

    @Override
    public double execute(double arg) {
        return arg * (-1);
    }

}
