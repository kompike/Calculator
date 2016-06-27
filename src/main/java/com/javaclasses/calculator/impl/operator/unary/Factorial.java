package com.javaclasses.calculator.impl.operator.unary;

import com.javaclasses.calculator.impl.UnaryOperator;

/**
 * Implementation of factorial
 */
public class Factorial extends UnaryOperator {

    public Factorial(Notation notation) {
        super(notation);
    }

    @Override
    public double execute(double arg) {

        int result = 1;

        for (double i = arg; i > 1; i--) {

            result *= i;
        }

        return result;
    }

}
