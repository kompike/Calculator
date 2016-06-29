package com.javaclasses.calculator.impl.function;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Function;

/**
 * Function implementation for math maximum
 */
public class MaxFunction implements Function {

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

        double max = args[0];

        for (double argument : args) {

            if (argument > max) {
                max = argument;
            }
        }

        return max;
    }

}
