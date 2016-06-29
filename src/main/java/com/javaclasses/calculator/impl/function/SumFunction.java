package com.javaclasses.calculator.impl.function;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Function;

/**
 * Function implementation for math sum
 */
public class SumFunction implements Function {

    @Override
    public int getMinimumArgumentsNumber() {
        return 2;
    }

    @Override
    public int getMaximumArgumentsNumber() {
        return Integer.MAX_VALUE;
    }

    @Override
    public double execute(Double... args) throws IncorrectExpressionException {

        double sum = 0;

        for (double argument : args) {
            sum += argument;
        }

        return sum;
    }

}
