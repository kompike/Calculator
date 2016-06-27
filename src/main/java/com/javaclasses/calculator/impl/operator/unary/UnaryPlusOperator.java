package com.javaclasses.calculator.impl.operator.unary;

import com.javaclasses.calculator.impl.UnaryOperator;

/**
 * Implementation of unary plus operator
 */
public class UnaryPlusOperator extends UnaryOperator {

    public UnaryPlusOperator(Notation notation) {
        super(notation);
    }

    @Override
    public double execute(double arg) {
        return arg;
    }

}
